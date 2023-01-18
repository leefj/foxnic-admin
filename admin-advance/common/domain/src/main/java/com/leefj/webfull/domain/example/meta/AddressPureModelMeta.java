package com.leefj.webfull.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
 * @sign FC1F5458E0CE2C2B2BF0A60795FB794C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AddressPureModelMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> ID_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> NAME_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,NAME, java.lang.String.class, "收件人姓名", "收件人姓名", java.lang.String.class, null);
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final String PHONE_NUMBER="phoneNumber";
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> PHONE_NUMBER_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,PHONE_NUMBER, java.lang.String.class, "收件人手机", "收件人手机", java.lang.String.class, null);
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> ADDRESS_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,ADDRESS, java.lang.String.class, "收件地址", "收件地址", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final String REGION_TYPE="regionType";
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> REGION_TYPE_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,REGION_TYPE, java.lang.String.class, "类型", "类型，A:国内；B:国外", java.lang.String.class, null);
	
	/**
	 * 地区位置 , 地区位置，东北、华北等 , 类型: java.lang.String
	*/
	public static final String REGION_LOCATION="regionLocation";
	
	/**
	 * 地区位置 , 地区位置，东北、华北等 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> REGION_LOCATION_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,REGION_LOCATION, java.lang.String.class, "地区位置", "地区位置，东北、华北等", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressPureModel,java.lang.String> NOTES_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressPureModel.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PHONE_NUMBER , ADDRESS , REGION_TYPE , REGION_LOCATION , NOTES };
}