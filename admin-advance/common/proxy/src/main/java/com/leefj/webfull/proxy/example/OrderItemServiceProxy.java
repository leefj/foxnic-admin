package com.leefj.webfull.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.leefj.webfull.domain.example.OrderItem;
import com.leefj.webfull.domain.example.OrderItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.leefj.webfull.proxy.WebFullServiceNames;

/**
 * <p>
 * 订单明细 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:17
 */
@FeignClient(value = WebFullServiceNames.WEBFULL_EXAMPLE, contextId = OrderItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface OrderItemServiceProxy {

    /**
     * 基础路径 , webfull-service-example
     */
    public static final String API_BASIC_PATH = "webfull-service-example";

    /**
     * API 上下文路径 , webfull-example-order-item
     */
    public static final String API_CONTEXT_PATH = "webfull-example-order-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加订单明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除订单明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除订单明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新订单明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存订单明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个订单明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个订单明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询订单明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询订单明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加订单明细
     */
    @RequestMapping(OrderItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "orderItemVO") OrderItemVO orderItemVO);

    /**
     * 删除订单明细
     */
    @RequestMapping(OrderItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除订单明细
     */
    @RequestMapping(OrderItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新订单明细
     */
    @RequestMapping(OrderItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "orderItemVO") OrderItemVO orderItemVO);

    /**
     * 更新订单明细
     */
    @RequestMapping(OrderItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "orderItemVO") OrderItemVO orderItemVO);

    /**
     * 获取订单明细
     */
    @RequestMapping(OrderItemServiceProxy.GET_BY_ID)
    Result<OrderItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个订单明细
     */
    @RequestMapping(OrderItemServiceProxy.GET_BY_IDS)
    Result<List<OrderItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询订单明细
     */
    @RequestMapping(OrderItemServiceProxy.QUERY_LIST)
    Result<List<OrderItem>> queryList(@RequestParam(name = "sample") OrderItemVO sample);

    /**
     * 分页查询订单明细
     */
    @RequestMapping(OrderItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<OrderItem>> queryPagedList(@RequestParam(name = "sample") OrderItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.leefj.webfull.example.controller.OrderItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static OrderItemServiceProxy api() {
        return APIProxy.get(OrderItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
