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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.leefj.webfull.proxy.example.ReimbursementServiceProxy;
import com.leefj.webfull.domain.example.meta.ReimbursementVOMeta;
import com.leefj.webfull.domain.example.Reimbursement;
import com.leefj.webfull.domain.example.ReimbursementVO;
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
import com.leefj.webfull.domain.example.meta.ReimbursementMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.leefj.webfull.example.service.IReimbursementService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 费用报销单接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:18
*/

@InDoc
@Api(tags = "费用报销单")
@RestController("WebfullExampleReimbursementController")
public class ReimbursementController extends SuperController implements BpmCallbackController{

	@Autowired
	private IReimbursementService reimbursementService;


	/**
	 * 添加费用报销单
	*/
	@ApiOperation(value = "添加费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "费用名称" , required = false , dataTypeClass=String.class , example = "机票"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "报销金额" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "审批状态" , required = false , dataTypeClass=String.class , example = "审批中"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.INSERT)
	public Result insert(ReimbursementVO reimbursementVO) {
		Result result=reimbursementService.insert(reimbursementVO,false);
		return result;
	}



	/**
	 * 删除费用报销单
	*/
	@ApiOperation(value = "删除费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643103860822376448")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.DELETE)
	public Result deleteById(Long id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  reimbursementService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=reimbursementService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除费用报销单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = ReimbursementServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Long> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<Long, ReferCause> causeMap = reimbursementService.hasRefers(ids);
		// 收集可以删除的ID值
		List<Long> canDeleteIds = new ArrayList<>();
		for (Map.Entry<Long, ReferCause> e : causeMap.entrySet()) {
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
			Result result=reimbursementService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=reimbursementService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新费用报销单
	*/
	@ApiOperation(value = "更新费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "费用名称" , required = false , dataTypeClass=String.class , example = "机票"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "报销金额" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "审批状态" , required = false , dataTypeClass=String.class , example = "审批中"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { ReimbursementVOMeta.PAGE_INDEX , ReimbursementVOMeta.PAGE_SIZE , ReimbursementVOMeta.SEARCH_FIELD , ReimbursementVOMeta.FUZZY_FIELD , ReimbursementVOMeta.SEARCH_VALUE , ReimbursementVOMeta.DIRTY_FIELDS , ReimbursementVOMeta.SORT_FIELD , ReimbursementVOMeta.SORT_TYPE , ReimbursementVOMeta.DATA_ORIGIN , ReimbursementVOMeta.QUERY_LOGIC , ReimbursementVOMeta.IDS } )
	@SentinelResource(value = ReimbursementServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.UPDATE)
	public Result update(ReimbursementVO reimbursementVO) {
		Result result=reimbursementService.update(reimbursementVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存费用报销单
	*/
	@ApiOperation(value = "保存费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "费用名称" , required = false , dataTypeClass=String.class , example = "机票"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "报销金额" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "审批状态" , required = false , dataTypeClass=String.class , example = "审批中"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ReimbursementVOMeta.PAGE_INDEX , ReimbursementVOMeta.PAGE_SIZE , ReimbursementVOMeta.SEARCH_FIELD , ReimbursementVOMeta.FUZZY_FIELD , ReimbursementVOMeta.SEARCH_VALUE , ReimbursementVOMeta.DIRTY_FIELDS , ReimbursementVOMeta.SORT_FIELD , ReimbursementVOMeta.SORT_TYPE , ReimbursementVOMeta.DATA_ORIGIN , ReimbursementVOMeta.QUERY_LOGIC , ReimbursementVOMeta.IDS } )
	@SentinelResource(value = ReimbursementServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.SAVE)
	public Result save(ReimbursementVO reimbursementVO) {
		Result result=reimbursementService.save(reimbursementVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取费用报销单
	*/
	@ApiOperation(value = "获取费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.GET_BY_ID)
	public Result<Reimbursement> getById(Long id) {
		Result<Reimbursement> result=new Result<>();
		Reimbursement reimbursement=reimbursementService.getById(id);
		result.success(true).data(reimbursement);
		return result;
	}


	/**
	 * 批量获取费用报销单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取费用报销单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ReimbursementVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = ReimbursementServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.GET_BY_IDS)
	public Result<List<Reimbursement>> getByIds(List<Long> ids) {
		Result<List<Reimbursement>> result=new Result<>();
		List<Reimbursement> list=reimbursementService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询费用报销单
	*/
	@ApiOperation(value = "查询费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "费用名称" , required = false , dataTypeClass=String.class , example = "机票"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "报销金额" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "审批状态" , required = false , dataTypeClass=String.class , example = "审批中"),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { ReimbursementVOMeta.PAGE_INDEX , ReimbursementVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ReimbursementServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.QUERY_LIST)
	public Result<List<Reimbursement>> queryList(ReimbursementVO sample) {
		Result<List<Reimbursement>> result=new Result<>();
		List<Reimbursement> list=reimbursementService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询费用报销单
	*/
	@ApiOperation(value = "分页查询费用报销单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "费用名称" , required = false , dataTypeClass=String.class , example = "机票"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "报销金额" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "审批状态" , required = false , dataTypeClass=String.class , example = "审批中"),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Reimbursement>> queryPagedList(ReimbursementVO sample) {
		Result<PagedList<Reimbursement>> result=new Result<>();
		PagedList<Reimbursement> list=reimbursementService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 填充流程相关的属性
		reimbursementService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = ReimbursementServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		return reimbursementService.onProcessCallback(event);
	}




}