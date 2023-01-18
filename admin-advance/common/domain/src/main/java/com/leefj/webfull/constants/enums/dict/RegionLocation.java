package com.leefj.webfull.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-08-13 12:52:08
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum RegionLocation  implements CodeTextEnum {
	
	/**
	 * 东北
	*/
	DONGBEI("dongbei" , "东北"),
	
	/**
	 * 华南
	*/
	HUANAN("huanan" , "华南"),
	;
	
	private String code;
	private String text;
	private RegionLocation(String code,String text)  {
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
	public static RegionLocation parseByCode(String code) {
		return (RegionLocation) EnumUtil.parseByCode(RegionLocation.values(),code);
	}
}