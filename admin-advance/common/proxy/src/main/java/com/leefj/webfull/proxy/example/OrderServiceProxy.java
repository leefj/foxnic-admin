package com.leefj.webfull.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.leefj.webfull.domain.example.Order;
import com.leefj.webfull.domain.example.OrderVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.leefj.webfull.proxy.WebFullServiceNames;

/**
 * <p>
 * 订单 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:17
 */
@FeignClient(value = WebFullServiceNames.WEBFULL_EXAMPLE, contextId = OrderServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface OrderServiceProxy {

    /**
     * 基础路径 , webfull-service-example
     */
    public static final String API_BASIC_PATH = "webfull-service-example";

    /**
     * API 上下文路径 , webfull-example-order
     */
    public static final String API_CONTEXT_PATH = "webfull-example-order";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加订单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除订单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除订单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新订单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存订单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个订单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个订单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询订单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询订单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加订单
     */
    @RequestMapping(OrderServiceProxy.INSERT)
    Result insert(@RequestParam(name = "orderVO") OrderVO orderVO);

    /**
     * 删除订单
     */
    @RequestMapping(OrderServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除订单
     */
    @RequestMapping(OrderServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新订单
     */
    @RequestMapping(OrderServiceProxy.UPDATE)
    Result update(@RequestParam(name = "orderVO") OrderVO orderVO);

    /**
     * 更新订单
     */
    @RequestMapping(OrderServiceProxy.SAVE)
    Result save(@RequestParam(name = "orderVO") OrderVO orderVO);

    /**
     * 获取订单
     */
    @RequestMapping(OrderServiceProxy.GET_BY_ID)
    Result<Order> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个订单
     */
    @RequestMapping(OrderServiceProxy.GET_BY_IDS)
    Result<List<Order>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询订单
     */
    @RequestMapping(OrderServiceProxy.QUERY_LIST)
    Result<List<Order>> queryList(@RequestParam(name = "sample") OrderVO sample);

    /**
     * 分页查询订单
     */
    @RequestMapping(OrderServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Order>> queryPagedList(@RequestParam(name = "sample") OrderVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.leefj.webfull.example.controller.OrderController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static OrderServiceProxy api() {
        return APIProxy.get(OrderServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
