package com.leefj.webfull.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import com.leefj.webfull.domain.example.Reimbursement;
import com.leefj.webfull.domain.example.ReimbursementVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.leefj.webfull.proxy.WebFullServiceNames;

/**
 * <p>
 * 费用报销单 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:18
 */
@FeignClient(value = WebFullServiceNames.WEBFULL_EXAMPLE, contextId = ReimbursementServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ReimbursementServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , webfull-service-example
     */
    public static final String API_BASIC_PATH = "webfull-service-example";

    /**
     * API 上下文路径 , webfull-example-reimbursement
     */
    public static final String API_CONTEXT_PATH = "webfull-example-reimbursement";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加费用报销单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除费用报销单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除费用报销单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新费用报销单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存费用报销单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个费用报销单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个费用报销单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询费用报销单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询费用报销单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.INSERT)
    Result insert(@RequestParam(name = "reimbursementVO") ReimbursementVO reimbursementVO);

    /**
     * 删除费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Long id);

    /**
     * 批量删除费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 更新费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.UPDATE)
    Result update(@RequestParam(name = "reimbursementVO") ReimbursementVO reimbursementVO);

    /**
     * 更新费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.SAVE)
    Result save(@RequestParam(name = "reimbursementVO") ReimbursementVO reimbursementVO);

    /**
     * 获取费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.GET_BY_ID)
    Result<Reimbursement> getById(@RequestParam(name = "id") Long id);

    /**
     * 获取多个费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.GET_BY_IDS)
    Result<List<Reimbursement>> getByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 查询费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.QUERY_LIST)
    Result<List<Reimbursement>> queryList(@RequestParam(name = "sample") ReimbursementVO sample);

    /**
     * 分页查询费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Reimbursement>> queryPagedList(@RequestParam(name = "sample") ReimbursementVO sample);

    /**
     * 分页查询费用报销单
     */
    @RequestMapping(ReimbursementServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.leefj.webfull.example.controller.ReimbursementController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ReimbursementServiceProxy api() {
        return APIProxy.get(ReimbursementServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
