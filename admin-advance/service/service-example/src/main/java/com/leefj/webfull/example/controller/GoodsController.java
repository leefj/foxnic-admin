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


import com.leefj.webfull.proxy.example.GoodsServiceProxy;
import com.leefj.webfull.domain.example.meta.GoodsVOMeta;
import com.leefj.webfull.domain.example.Goods;
import com.leefj.webfull.domain.example.GoodsVO;
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
import com.leefj.webfull.domain.example.meta.GoodsMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.leefj.webfull.example.service.IGoodsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商品接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
*/

@InDoc
@Api(tags = "商品")
@RestController("WebfullExampleGoodsController")
public class GoodsController extends SuperController {

	@Autowired
	private IGoodsService goodsService;


	/**
	 * 添加商品
	*/
	@ApiOperation(value = "添加商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583020505427087360"),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "商品名" , required = false , dataTypeClass=String.class , example = "苹果"),
		@ApiImplicitParam(name = GoodsVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class , example = "6.00"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = GoodsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.INSERT)
	public Result insert(GoodsVO goodsVO) {
		Result result=goodsService.insert(goodsVO,false);
		return result;
	}



	/**
	 * 删除商品
	*/
	@ApiOperation(value = "删除商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583020505427087360")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = GoodsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  goodsService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=goodsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除商品 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = GoodsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = goodsService.hasRefers(ids);
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
			Result result=goodsService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=goodsService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新商品
	*/
	@ApiOperation(value = "更新商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583020505427087360"),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "商品名" , required = false , dataTypeClass=String.class , example = "苹果"),
		@ApiImplicitParam(name = GoodsVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class , example = "6.00"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.FUZZY_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.DIRTY_FIELDS , GoodsVOMeta.SORT_FIELD , GoodsVOMeta.SORT_TYPE , GoodsVOMeta.DATA_ORIGIN , GoodsVOMeta.QUERY_LOGIC , GoodsVOMeta.IDS } )
	@SentinelResource(value = GoodsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.UPDATE)
	public Result update(GoodsVO goodsVO) {
		Result result=goodsService.update(goodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存商品
	*/
	@ApiOperation(value = "保存商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583020505427087360"),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "商品名" , required = false , dataTypeClass=String.class , example = "苹果"),
		@ApiImplicitParam(name = GoodsVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class , example = "6.00"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.FUZZY_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.DIRTY_FIELDS , GoodsVOMeta.SORT_FIELD , GoodsVOMeta.SORT_TYPE , GoodsVOMeta.DATA_ORIGIN , GoodsVOMeta.QUERY_LOGIC , GoodsVOMeta.IDS } )
	@SentinelResource(value = GoodsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.SAVE)
	public Result save(GoodsVO goodsVO) {
		Result result=goodsService.save(goodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取商品
	*/
	@ApiOperation(value = "获取商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = GoodsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.GET_BY_ID)
	public Result<Goods> getById(String id) {
		Result<Goods> result=new Result<>();
		Goods goods=goodsService.getById(id);
		result.success(true).data(goods);
		return result;
	}


	/**
	 * 批量获取商品 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商品")
		@ApiImplicitParams({
				@ApiImplicitParam(name = GoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = GoodsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.GET_BY_IDS)
	public Result<List<Goods>> getByIds(List<String> ids) {
		Result<List<Goods>> result=new Result<>();
		List<Goods> list=goodsService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商品
	*/
	@ApiOperation(value = "查询商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583020505427087360"),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "商品名" , required = false , dataTypeClass=String.class , example = "苹果"),
		@ApiImplicitParam(name = GoodsVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class , example = "6.00"),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GoodsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.QUERY_LIST)
	public Result<List<Goods>> queryList(GoodsVO sample) {
		Result<List<Goods>> result=new Result<>();
		List<Goods> list=goodsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商品
	*/
	@ApiOperation(value = "分页查询商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583020505427087360"),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "商品名" , required = false , dataTypeClass=String.class , example = "苹果"),
		@ApiImplicitParam(name = GoodsVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class , example = "6.00"),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = GoodsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Goods>> queryPagedList(GoodsVO sample) {
		Result<PagedList<Goods>> result=new Result<>();
		PagedList<Goods> list=goodsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}