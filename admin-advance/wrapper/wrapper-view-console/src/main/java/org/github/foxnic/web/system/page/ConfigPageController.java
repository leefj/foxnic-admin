package org.github.foxnic.web.system.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 系统配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
*/

@Controller("SysConfigPageController")
@RequestMapping(ConfigPageController.prefix)
public class ConfigPageController {
	
	public static final String prefix="pages/system/config";

	/**
	 * 系统配置 功能主页面
	 */
	@RequestMapping("/config_list.html")
	public String list(Model model) {
		return prefix+"/config_list";
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/config_form.html")
	public String form(Model model) {
		return prefix+"/config_form";
	}
}