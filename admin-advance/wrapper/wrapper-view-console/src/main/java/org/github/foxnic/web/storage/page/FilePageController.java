package org.github.foxnic.web.storage.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 系统文件 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 05:14:07
*/

@Controller("SysFilePageController")
@RequestMapping(FilePageController.prefix)
public class FilePageController {
	
	public static final String prefix="pages/system/file";

	/**
	 * 系统文件 功能主页面
	 */
	@RequestMapping("/file_list.html")
	public String list(Model model) {
		return prefix+"/file_list";
	}

	/**
	 * 系统文件 表单页面
	 */
	@RequestMapping("/file_form.html")
	public String form(Model model) {
		return prefix+"/file_form";
	}
}