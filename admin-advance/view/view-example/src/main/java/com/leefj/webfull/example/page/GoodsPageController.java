package com.leefj.webfull.example.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.leefj.webfull.proxy.example.GoodsServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 商品模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
*/

@Controller("WebfullExampleGoodsPageController")
@RequestMapping(GoodsPageController.prefix)
public class GoodsPageController extends ViewController {
	
	public static final String prefix="business/webfull-example/goods";

	private GoodsServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public GoodsServiceProxy proxy() {
		if(proxy==null) {
			proxy=GoodsServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 商品 功能主页面
	 */
	@RequestMapping("/goods_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/goods_list";
	}

	/**
	 * 商品 表单页面
	 */
	@RequestMapping("/goods_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/goods_form";
	}
}