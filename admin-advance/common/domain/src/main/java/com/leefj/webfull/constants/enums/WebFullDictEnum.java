package com.leefj.webfull.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-08-13 12:52:08
 * @author 李方捷 , leefangjie@qq.com
 * 从 select distinct code,name from sys_dict WHERE deleted=0 and module in ('610152549789466624') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum WebFullDictEnum implements CodeTextEnum {
	
	/**
	 * 地区位置
	*/
	REGION_LOCATION("region_location" , "地区位置"),
	;
	
	private String code;
	private String text;
	private WebFullDictEnum(String code,String text)  {
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
	public static WebFullDictEnum parseByCode(String code) {
		return (WebFullDictEnum) EnumUtil.parseByCode(WebFullDictEnum.values(),code);
	}
}