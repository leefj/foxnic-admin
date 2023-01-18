package com.leefj.webfull.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-08-13 12:52:07
 * @author 李方捷 , leefangjie@qq.com
 * 从 select distinct code,name from sys_config WHERE deleted=0 and code like 'webfull%' 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum WebFullConfigEnum implements CodeTextEnum {
	
	/**
	 * WebFull名称
	*/
	WEBFULL_NAME("webfull.name" , "WebFull名称"),
	;
	
	private String code;
	private String text;
	private WebFullConfigEnum(String code,String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
	
	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static WebFullConfigEnum parseByCode(String code) {
		return (WebFullConfigEnum) EnumUtil.parseByCode(WebFullConfigEnum.values(),code);
	}
}