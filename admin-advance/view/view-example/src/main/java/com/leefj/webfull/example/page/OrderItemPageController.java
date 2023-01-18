package com.leefj.webfull.example.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.leefj.webfull.proxy.example.OrderItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 订单明细模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:18
*/

@Controller("WebfullExampleOrderItemPageController")
@RequestMapping(OrderItemPageController.prefix)
public class OrderItemPageController extends ViewController {
	
	public static final String prefix="business/webfull-example/order_item";

	private OrderItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public OrderItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=OrderItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 订单明细 功能主页面
	 */
	@RequestMapping("/order_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/order_item_list";
	}

	/**
	 * 订单明细 表单页面
	 */
	@RequestMapping("/order_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/order_item_form";
	}
}