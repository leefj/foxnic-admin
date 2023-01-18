package com.leefj.webfull.example.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.leefj.webfull.proxy.example.OrderServiceProxy;
import com.leefj.webfull.domain.example.meta.OrderVOMeta;
import com.leefj.webfull.domain.example.Order;
import com.leefj.webfull.domain.example.OrderVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.leefj.webfull.domain.example.meta.OrderMeta;
import java.math.BigDecimal;
import com.leefj.webfull.domain.example.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.leefj.webfull.example.service.IOrderService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 订单接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:17
*/

@InDoc
@Api(tags = "订单")
@RestController("WebfullExampleOrderController")
public class OrderController extends SuperController {

	@Autowired
	private IOrderService orderService;


	/**
	 * 添加订单
	*/
	@ApiOperation(value = "添加订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = OrderServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.INSERT)
	public Result insert(OrderVO orderVO) {
		Result result=orderService.insert(orderVO,false);
		return result;
	}



	/**
	 * 删除订单
	*/
	@ApiOperation(value = "删除订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = OrderServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  orderService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=orderService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = OrderServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = orderService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=orderService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=orderService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新订单
	*/
	@ApiOperation(value = "更新订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE , OrderVOMeta.SEARCH_FIELD , OrderVOMeta.FUZZY_FIELD , OrderVOMeta.SEARCH_VALUE , OrderVOMeta.DIRTY_FIELDS , OrderVOMeta.SORT_FIELD , OrderVOMeta.SORT_TYPE , OrderVOMeta.DATA_ORIGIN , OrderVOMeta.QUERY_LOGIC , OrderVOMeta.IDS } )
	@SentinelResource(value = OrderServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.UPDATE)
	public Result update(OrderVO orderVO) {
		Result result=orderService.update(orderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存订单
	*/
	@ApiOperation(value = "保存订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE , OrderVOMeta.SEARCH_FIELD , OrderVOMeta.FUZZY_FIELD , OrderVOMeta.SEARCH_VALUE , OrderVOMeta.DIRTY_FIELDS , OrderVOMeta.SORT_FIELD , OrderVOMeta.SORT_TYPE , OrderVOMeta.DATA_ORIGIN , OrderVOMeta.QUERY_LOGIC , OrderVOMeta.IDS } )
	@SentinelResource(value = OrderServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.SAVE)
	public Result save(OrderVO orderVO) {
		Result result=orderService.save(orderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取订单
	*/
	@ApiOperation(value = "获取订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = OrderServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.GET_BY_ID)
	public Result<Order> getById(String id) {
		Result<Order> result=new Result<>();
		Order order=orderService.getById(id);
		// join 关联的对象
		orderService.dao().fill(order)
			.with(OrderMeta.ADDRESS)
			.execute();
		result.success(true).data(order);
		return result;
	}


	/**
	 * 批量获取订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取订单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = OrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = OrderServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.GET_BY_IDS)
	public Result<List<Order>> getByIds(List<String> ids) {
		Result<List<Order>> result=new Result<>();
		List<Order> list=orderService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询订单
	*/
	@ApiOperation(value = "查询订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OrderServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.QUERY_LIST)
	public Result<List<Order>> queryList(OrderVO sample) {
		Result<List<Order>> result=new Result<>();
		List<Order> list=orderService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询订单
	*/
	@ApiOperation(value = "分页查询订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = OrderServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Order>> queryPagedList(OrderVO sample) {
		Result<PagedList<Order>> result=new Result<>();
		PagedList<Order> list=orderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		orderService.dao().fill(list)
			.with(OrderMeta.ADDRESS)
			.execute();
		result.success(true).data(list);
		return result;
	}






}