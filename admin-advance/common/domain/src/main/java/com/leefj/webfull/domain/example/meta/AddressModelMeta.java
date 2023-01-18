package com.leefj.webfull.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.leefj.webfull.domain.example.AddressModel;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
 * @sign 8C5453A926F1CFD20310681A88DDBD24
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AddressModelMeta {
	
	/**
	 * 自定义属性 , 我的自定义属性 , 类型: java.lang.String
	*/
	public static final String MY_PROPERTY="myProperty";
	
	/**
	 * 自定义属性 , 我的自定义属性 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> MY_PROPERTY_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,MY_PROPERTY, java.lang.String.class, "自定义属性", "我的自定义属性", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> ID_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> NAME_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,NAME, java.lang.String.class, "收件人姓名", "收件人姓名", java.lang.String.class, null);
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final String PHONE_NUMBER="phoneNumber";
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> PHONE_NUMBER_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,PHONE_NUMBER, java.lang.String.class, "收件人手机", "收件人手机", java.lang.String.class, null);
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> ADDRESS_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,ADDRESS, java.lang.String.class, "收件地址", "收件地址", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final String REGION_TYPE="regionType";
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> REGION_TYPE_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,REGION_TYPE, java.lang.String.class, "类型", "类型，A:国内；B:国外", java.lang.String.class, null);
	
	/**
	 * 地区位置 , 地区位置，东北、华北等 , 类型: java.lang.String
	*/
	public static final String REGION_LOCATION="regionLocation";
	
	/**
	 * 地区位置 , 地区位置，东北、华北等 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> REGION_LOCATION_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,REGION_LOCATION, java.lang.String.class, "地区位置", "地区位置，东北、华北等", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.AddressModel,java.lang.String> NOTES_PROP = new BeanProperty(com.leefj.webfull.domain.example.AddressModel.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ MY_PROPERTY , ID , NAME , PHONE_NUMBER , ADDRESS , REGION_TYPE , REGION_LOCATION , NOTES };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.leefj.webfull.domain.example.AddressModel {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 自定义属性
		 * @param myProperty 自定义属性
		 * @return 当前对象
		*/
		public AddressModel setMyProperty(String myProperty) {
			super.change(MY_PROPERTY,super.getMyProperty(),myProperty);
			super.setMyProperty(myProperty);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AddressModel setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 收件人姓名
		 * @param name 收件人姓名
		 * @return 当前对象
		*/
		public AddressModel setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 收件人手机
		 * @param phoneNumber 收件人手机
		 * @return 当前对象
		*/
		public AddressModel setPhoneNumber(String phoneNumber) {
			super.change(PHONE_NUMBER,super.getPhoneNumber(),phoneNumber);
			super.setPhoneNumber(phoneNumber);
			return this;
		}
		
		/**
		 * 设置 收件地址
		 * @param address 收件地址
		 * @return 当前对象
		*/
		public AddressModel setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param regionType 类型
		 * @return 当前对象
		*/
		public AddressModel setRegionType(String regionType) {
			super.change(REGION_TYPE,super.getRegionType(),regionType);
			super.setRegionType(regionType);
			return this;
		}
		
		/**
		 * 设置 地区位置
		 * @param regionLocation 地区位置
		 * @return 当前对象
		*/
		public AddressModel setRegionLocation(String regionLocation) {
			super.change(REGION_LOCATION,super.getRegionLocation(),regionLocation);
			super.setRegionLocation(regionLocation);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AddressModel setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AddressModel clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AddressModel duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setPhoneNumber(this.getPhoneNumber());
			inst.setAddress(this.getAddress());
			inst.setNotes(this.getNotes());
			inst.setRegionType(this.getRegionType());
			inst.setName(this.getName());
			inst.setId(this.getId());
			inst.setRegionLocation(this.getRegionLocation());
			if(all) {
				inst.setMyProperty(this.getMyProperty());
			}
			inst.clearModifies();
			return inst;
		}

	}
}