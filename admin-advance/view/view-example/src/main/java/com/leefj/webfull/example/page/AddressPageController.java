package com.leefj.webfull.example.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.leefj.webfull.proxy.example.AddressServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 订单地址模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
*/

@Controller("WebfullExampleAddressPageController")
@RequestMapping(AddressPageController.prefix)
public class AddressPageController extends ViewController {
	
	public static final String prefix="business/webfull-example/address";

	private AddressServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AddressServiceProxy proxy() {
		if(proxy==null) {
			proxy=AddressServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 订单地址 功能主页面
	 */
	@RequestMapping("/address_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/address_list";
	}

	/**
	 * 订单地址 表单页面
	 */
	@RequestMapping("/address_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/address_form";
	}
}