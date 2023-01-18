package com.leefj.webfull.constants.enums.example;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


public enum RegionType implements CodeTextEnum {

	/**
	 * 国内
	*/
	INLAND("inland" , "国内"),

	/**
	 * 国外
	*/
	FOREIGN("foreign" , "国外"),
	;

	private String code;
	private String text;
	private RegionType(String code, String text)  {
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
	public static RegionType parseByCode(String code) {
		return (RegionType) EnumUtil.parseByCode(RegionType.values(),code);
	}
}
