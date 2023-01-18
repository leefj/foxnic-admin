package com.leefj.webfull.domain.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import com.leefj.webfull.domain.example.meta.AddressPureModelMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 订单地址
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
 * @sign FC1F5458E0CE2C2B2BF0A60795FB794C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel()
public class AddressPureModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键：主键
	*/
	@ApiModelProperty(required = false,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 收件人姓名：收件人姓名
	*/
	@ApiModelProperty(required = false,value="收件人姓名" , notes = "收件人姓名")
	private String name;
	
	/**
	 * 收件人手机：收件人手机
	*/
	@ApiModelProperty(required = false,value="收件人手机" , notes = "收件人手机")
	private String phoneNumber;
	
	/**
	 * 收件地址：收件地址
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址")
	private String address;
	
	/**
	 * 类型：类型，A:国内；B:国外
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型，A:国内；B:国外")
	private String regionType;
	
	/**
	 * 地区位置：地区位置，东北、华北等
	*/
	@ApiModelProperty(required = false,value="地区位置" , notes = "地区位置，东北、华北等")
	private String regionLocation;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AddressPureModel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 收件人姓名<br>
	 * 收件人姓名
	 * @return 收件人姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 收件人姓名
	 * @param name 收件人姓名
	 * @return 当前对象
	*/
	public AddressPureModel setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 收件人手机<br>
	 * 收件人手机
	 * @return 收件人手机
	*/
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * 设置 收件人手机
	 * @param phoneNumber 收件人手机
	 * @return 当前对象
	*/
	public AddressPureModel setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 收件地址
	 * @return 收件地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public AddressPureModel setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型，A:国内；B:国外
	 * @return 类型
	*/
	public String getRegionType() {
		return regionType;
	}
	
	/**
	 * 设置 类型
	 * @param regionType 类型
	 * @return 当前对象
	*/
	public AddressPureModel setRegionType(String regionType) {
		this.regionType=regionType;
		return this;
	}
	
	/**
	 * 获得 地区位置<br>
	 * 地区位置，东北、华北等
	 * @return 地区位置
	*/
	public String getRegionLocation() {
		return regionLocation;
	}
	
	/**
	 * 设置 地区位置
	 * @param regionLocation 地区位置
	 * @return 当前对象
	*/
	public AddressPureModel setRegionLocation(String regionLocation) {
		this.regionLocation=regionLocation;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public AddressPureModel setNotes(String notes) {
		this.notes=notes;
		return this;
	}

	/**
	 * 创建一个 AddressPureModel，等同于 new
	 * @return AddressPureModel 对象
	*/
	@Transient
	public static AddressPureModel create() {
		return new AddressPureModel();
	}

	/**
	 * 将 Map 转换成 AddressPureModel
	 * @param addressMap 包含实体信息的 Map 对象
	 * @return AddressPureModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressPureModel createFrom(Map<String,Object> addressMap) {
		if(addressMap==null) return null;
		AddressPureModel po = new AddressPureModel();
		BeanUtil.copy(addressMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AddressPureModel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AddressPureModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressPureModel createFrom(Object pojo) {
		if(pojo==null) return null;
		AddressPureModel po = new AddressPureModel();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AddressPureModel duplicate(boolean all) {
		AddressPureModel inst = new AddressPureModel();
		inst.setPhoneNumber(this.getPhoneNumber());
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setRegionType(this.getRegionType());
		inst.setName(this.getName());
		inst.setId(this.getId());
		inst.setRegionLocation(this.getRegionLocation());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AddressPureModel clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AddressPureModel clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AddressPureModel , 转换好的 PoJo 对象
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
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setPhoneNumber(DataParser.parse(String.class, map.get(AddressPureModelMeta.PHONE_NUMBER)));
			this.setAddress(DataParser.parse(String.class, map.get(AddressPureModelMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(AddressPureModelMeta.NOTES)));
			this.setRegionType(DataParser.parse(String.class, map.get(AddressPureModelMeta.REGION_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AddressPureModelMeta.NAME)));
			this.setId(DataParser.parse(String.class, map.get(AddressPureModelMeta.ID)));
			this.setRegionLocation(DataParser.parse(String.class, map.get(AddressPureModelMeta.REGION_LOCATION)));
			// others
			return true;
		} else {
			try {
				this.setPhoneNumber( (String)map.get(AddressPureModelMeta.PHONE_NUMBER));
				this.setAddress( (String)map.get(AddressPureModelMeta.ADDRESS));
				this.setNotes( (String)map.get(AddressPureModelMeta.NOTES));
				this.setRegionType( (String)map.get(AddressPureModelMeta.REGION_TYPE));
				this.setName( (String)map.get(AddressPureModelMeta.NAME));
				this.setId( (String)map.get(AddressPureModelMeta.ID));
				this.setRegionLocation( (String)map.get(AddressPureModelMeta.REGION_LOCATION));
				// others
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
			this.setPhoneNumber(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.PHONE_NUMBER)));
			this.setAddress(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.NOTES)));
			this.setRegionType(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.REGION_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.ID)));
			this.setRegionLocation(DataParser.parse(String.class, r.getValue(AddressPureModelMeta.REGION_LOCATION)));
			return true;
		} else {
			try {
				this.setPhoneNumber( (String)r.getValue(AddressPureModelMeta.PHONE_NUMBER));
				this.setAddress( (String)r.getValue(AddressPureModelMeta.ADDRESS));
				this.setNotes( (String)r.getValue(AddressPureModelMeta.NOTES));
				this.setRegionType( (String)r.getValue(AddressPureModelMeta.REGION_TYPE));
				this.setName( (String)r.getValue(AddressPureModelMeta.NAME));
				this.setId( (String)r.getValue(AddressPureModelMeta.ID));
				this.setRegionLocation( (String)r.getValue(AddressPureModelMeta.REGION_LOCATION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}