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
 * ??????????????????????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2023-01-11 09:59:18
*/

@InDoc
@Api(tags = "???????????????")
@RestController("WebfullExampleReimbursementController")
public class ReimbursementController extends SuperController implements BpmCallbackController{

	@Autowired
	private IReimbursementService reimbursementService;


	/**
	 * ?????????????????????
	*/
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "????????????" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "????????????" , required = false , dataTypeClass=String.class , example = "?????????"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="????????? , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.INSERT)
	public Result insert(ReimbursementVO reimbursementVO) {
		Result result=reimbursementService.insert(reimbursementVO,false);
		return result;
	}



	/**
	 * ?????????????????????
	*/
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "643103860822376448")
	})
	@ApiOperationSupport(order=2 , author="????????? , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.DELETE)
	public Result deleteById(Long id) {
		this.validator().asserts(id).require("??????id???");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// ????????????
		ReferCause cause =  reimbursementService.hasRefers(id);
		// ????????????????????????
		this.validator().asserts(cause.hasRefer()).requireEqual("??????????????????????????????"+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=reimbursementService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * ??????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="????????? , leefangjie@qq.com") 
	@SentinelResource(value = ReimbursementServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Long> ids) {

		// ????????????
		this.validator().asserts(ids).require("??????ids??????");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// ????????????
		Map<Long, ReferCause> causeMap = reimbursementService.hasRefers(ids);
		// ?????????????????????ID???
		List<Long> canDeleteIds = new ArrayList<>();
		for (Map.Entry<Long, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// ????????????
		if (canDeleteIds.isEmpty()) {
			// ?????????????????????????????????
			return ErrorDesc.failure().message("????????????????????????????????????").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// ????????????????????????
			Result result=reimbursementService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// ???????????????????????????
			Result result=reimbursementService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("????????? " + canDeleteIds.size() + " ??????????????? " + (ids.size() - canDeleteIds.size()) + " ?????????????????????").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// ?????????????????????????????????
			return ErrorDesc.success().message("?????????????????????");
		}
	}

	/**
	 * ?????????????????????
	*/
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "????????????" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "????????????" , required = false , dataTypeClass=String.class , example = "?????????"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="????????? , leefangjie@qq.com" ,  ignoreParameters = { ReimbursementVOMeta.PAGE_INDEX , ReimbursementVOMeta.PAGE_SIZE , ReimbursementVOMeta.SEARCH_FIELD , ReimbursementVOMeta.FUZZY_FIELD , ReimbursementVOMeta.SEARCH_VALUE , ReimbursementVOMeta.DIRTY_FIELDS , ReimbursementVOMeta.SORT_FIELD , ReimbursementVOMeta.SORT_TYPE , ReimbursementVOMeta.DATA_ORIGIN , ReimbursementVOMeta.QUERY_LOGIC , ReimbursementVOMeta.IDS } )
	@SentinelResource(value = ReimbursementServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.UPDATE)
	public Result update(ReimbursementVO reimbursementVO) {
		Result result=reimbursementService.update(reimbursementVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ?????????????????????
	*/
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "????????????" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "????????????" , required = false , dataTypeClass=String.class , example = "?????????"),
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
	 * ?????????????????????
	*/
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="????????? , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.GET_BY_ID)
	public Result<Reimbursement> getById(Long id) {
		Result<Reimbursement> result=new Result<>();
		Reimbursement reimbursement=reimbursementService.getById(id);
		result.success(true).data(reimbursement);
		return result;
	}


	/**
	 * ??????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
		@ApiOperation(value = "???????????????????????????")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ReimbursementVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="????????? , leefangjie@qq.com") 
		@SentinelResource(value = ReimbursementServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.GET_BY_IDS)
	public Result<List<Reimbursement>> getByIds(List<Long> ids) {
		Result<List<Reimbursement>> result=new Result<>();
		List<Reimbursement> list=reimbursementService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ?????????????????????
	*/
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "????????????" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "????????????" , required = false , dataTypeClass=String.class , example = "?????????"),
	})
	@ApiOperationSupport(order=5 , author="????????? , leefangjie@qq.com" ,  ignoreParameters = { ReimbursementVOMeta.PAGE_INDEX , ReimbursementVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ReimbursementServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.QUERY_LIST)
	public Result<List<Reimbursement>> queryList(ReimbursementVO sample) {
		Result<List<Reimbursement>> result=new Result<>();
		List<Reimbursement> list=reimbursementService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReimbursementVOMeta.ID , value = "??????" , required = true , dataTypeClass=Long.class , example = "643103860822376448"),
		@ApiImplicitParam(name = ReimbursementVOMeta.TITLE , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = ReimbursementVOMeta.AMOUNT , value = "????????????" , required = false , dataTypeClass=BigDecimal.class , example = "200.00"),
		@ApiImplicitParam(name = ReimbursementVOMeta.STATUS , value = "????????????" , required = false , dataTypeClass=String.class , example = "?????????"),
	})
	@ApiOperationSupport(order=8 , author="????????? , leefangjie@qq.com")
	@SentinelResource(value = ReimbursementServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Reimbursement>> queryPagedList(ReimbursementVO sample) {
		Result<PagedList<Reimbursement>> result=new Result<>();
		PagedList<Reimbursement> list=reimbursementService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// ???????????????????????????
		reimbursementService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  ??????????????????
     */
	@SentinelResource(value = ReimbursementServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReimbursementServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		return reimbursementService.onProcessCallback(event);
	}




}