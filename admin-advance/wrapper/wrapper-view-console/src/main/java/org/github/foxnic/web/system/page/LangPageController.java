package org.github.foxnic.web.system.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 语言条目表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
*/

@Controller("SysLangPageController")
@RequestMapping(LangPageController.prefix)
public class LangPageController {
	
	public static final String prefix="pages/system/lang";

	/**
	 * 语言条目 功能主页面
	 */
	@RequestMapping("/lang_list.html")
	public String list(Model model) {
		return prefix+"/lang_list";
	}

	/**
	 * 语言条目 表单页面
	 */
	@RequestMapping("/lang_form.html")
	public String form(Model model) {
		return prefix+"/lang_form";
	}
}