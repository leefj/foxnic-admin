package com.leefj.webfull.domain.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import com.leefj.webfull.domain.example.meta.AddressSubModelMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 订单地址
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
 * @sign 2D524AA15B0CEA67203758F0084B2AC9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(parent = AddressModel.class)
public class AddressSubModel extends AddressModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 邮编1：邮编1
	*/
	@ApiModelProperty(required = false,value="邮编1" , notes = "邮编1")
	private String postCode1;
	
	/**
	 * 邮编2：邮编2
	*/
	@ApiModelProperty(required = false,value="邮编2" , notes = "邮编2")
	private String postCode2;
	
	/**
	 * 获得 邮编1<br>
	 * 邮编1
	 * @return 邮编1
	*/
	public String getPostCode1() {
		return postCode1;
	}
	
	/**
	 * 设置 邮编1
	 * @param postCode1 邮编1
	 * @return 当前对象
	*/
	public AddressSubModel setPostCode1(String postCode1) {
		this.postCode1=postCode1;
		return this;
	}
	
	/**
	 * 获得 邮编2<br>
	 * 邮编2
	 * @return 邮编2
	*/
	public String getPostCode2() {
		return postCode2;
	}
	
	/**
	 * 设置 邮编2
	 * @param postCode2 邮编2
	 * @return 当前对象
	*/
	public AddressSubModel setPostCode2(String postCode2) {
		this.postCode2=postCode2;
		return this;
	}

	/**
	 * 将 Map 转换成 AddressSubModel
	 * @param addressMap 包含实体信息的 Map 对象
	 * @return AddressSubModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressSubModel createFrom(Map<String,Object> addressMap) {
		if(addressMap==null) return null;
		AddressSubModel po = create();
		EntityContext.copyProperties(po,addressMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AddressSubModel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AddressSubModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressSubModel createFrom(Object pojo) {
		if(pojo==null) return null;
		AddressSubModel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AddressSubModel duplicate(boolean all) {
		com.leefj.webfull.domain.example.meta.AddressSubModelMeta.$$proxy$$ inst = new com.leefj.webfull.domain.example.meta.AddressSubModelMeta.$$proxy$$();
		inst.setPhoneNumber(this.getPhoneNumber());
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setRegionType(this.getRegionType());
		inst.setName(this.getName());
		inst.setId(this.getId());
		inst.setRegionLocation(this.getRegionLocation());
		if(all) {
			inst.setPostCode2(this.getPostCode2());
			inst.setPostCode1(this.getPostCode1());
			inst.setMyProperty(this.getMyProperty());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AddressSubModel clone() {
		return duplicate(true);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AddressSubModel clone(boolean deep) {
		return EntityContext.clone(AddressSubModel.class,this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AddressSubModel , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)EntityContext.create((Class<? extends Entity>) pojoType,this);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 创建一个 AddressSubModel，等同于 new
	 * @return AddressSubModel 对象
	*/
	@Transient
	public static AddressSubModel create() {
		return new com.leefj.webfull.domain.example.meta.AddressSubModelMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setPhoneNumber(DataParser.parse(String.class, map.get(AddressSubModelMeta.PHONE_NUMBER)));
			this.setAddress(DataParser.parse(String.class, map.get(AddressSubModelMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(AddressSubModelMeta.NOTES)));
			this.setRegionType(DataParser.parse(String.class, map.get(AddressSubModelMeta.REGION_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AddressSubModelMeta.NAME)));
			this.setId(DataParser.parse(String.class, map.get(AddressSubModelMeta.ID)));
			this.setRegionLocation(DataParser.parse(String.class, map.get(AddressSubModelMeta.REGION_LOCATION)));
			// others
			this.setPostCode2(DataParser.parse(String.class, map.get(AddressSubModelMeta.POST_CODE2)));
			this.setPostCode1(DataParser.parse(String.class, map.get(AddressSubModelMeta.POST_CODE1)));
			this.setMyProperty(DataParser.parse(String.class, map.get(AddressSubModelMeta.MY_PROPERTY)));
			return true;
		} else {
			try {
				this.setPhoneNumber( (String)map.get(AddressSubModelMeta.PHONE_NUMBER));
				this.setAddress( (String)map.get(AddressSubModelMeta.ADDRESS));
				this.setNotes( (String)map.get(AddressSubModelMeta.NOTES));
				this.setRegionType( (String)map.get(AddressSubModelMeta.REGION_TYPE));
				this.setName( (String)map.get(AddressSubModelMeta.NAME));
				this.setId( (String)map.get(AddressSubModelMeta.ID));
				this.setRegionLocation( (String)map.get(AddressSubModelMeta.REGION_LOCATION));
				// others
				this.setPostCode2( (String)map.get(AddressSubModelMeta.POST_CODE2));
				this.setPostCode1( (String)map.get(AddressSubModelMeta.POST_CODE1));
				this.setMyProperty( (String)map.get(AddressSubModelMeta.MY_PROPERTY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setPhoneNumber(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.PHONE_NUMBER)));
			this.setAddress(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.NOTES)));
			this.setRegionType(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.REGION_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.ID)));
			this.setRegionLocation(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.REGION_LOCATION)));
			return true;
		} else {
			try {
				this.setPhoneNumber( (String)r.getValue(AddressSubModelMeta.PHONE_NUMBER));
				this.setAddress( (String)r.getValue(AddressSubModelMeta.ADDRESS));
				this.setNotes( (String)r.getValue(AddressSubModelMeta.NOTES));
				this.setRegionType( (String)r.getValue(AddressSubModelMeta.REGION_TYPE));
				this.setName( (String)r.getValue(AddressSubModelMeta.NAME));
				this.setId( (String)r.getValue(AddressSubModelMeta.ID));
				this.setRegionLocation( (String)r.getValue(AddressSubModelMeta.REGION_LOCATION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}