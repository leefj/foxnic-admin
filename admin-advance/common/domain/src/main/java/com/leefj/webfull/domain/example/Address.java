package com.leefj.webfull.domain.example;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.leefj.webfull.constants.db.WebFullTables.WEBFULL_EXAMPLE_ADDRESS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.leefj.webfull.domain.example.meta.AddressMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 订单地址
 * <p>订单地址 , 数据表 webfull_example_address 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
 * @sign ECBAC43BBB55CF099B8D084BD30689BD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "webfull_example_address")
@ApiModel(description = "订单地址 ; 订单地址 , 数据表 webfull_example_address 的PO类型")
public class Address extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WEBFULL_EXAMPLE_ADDRESS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "583028267108274176")
	private String id;
	
	/**
	 * 收件人姓名：收件人姓名
	*/
	@ApiModelProperty(required = false,value="收件人姓名" , notes = "收件人姓名" , example = "李方捷")
	private String name;
	
	/**
	 * 收件人手机：收件人手机
	*/
	@ApiModelProperty(required = false,value="收件人手机" , notes = "收件人手机" , example = "1234567333")
	private String phoneNumber;
	
	/**
	 * 收件地址：收件地址
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址" , example = "浙江省宁波市鄞州区鄞县大道二号")
	private String address;
	
	/**
	 * 类型：A:国内；B:国外
	*/
	@ApiModelProperty(required = true,value="类型" , notes = "A:国内；B:国外")
	private String regionType;
	
	/**
	 * 地区位置：东北、华北等
	*/
	@ApiModelProperty(required = false,value="地区位置" , notes = "东北、华北等")
	private String regionLocation;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-05-28 08:26:11")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-06-11 06:44:28")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "2")
	private Integer version;
	
	/**
	 * 订单量：每年收到的订单数量
	*/
	@ApiModelProperty(required = false,value="订单量" , notes = "每年收到的订单数量")
	private Integer orderCount;
	
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
	public Address setId(String id) {
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
	public Address setName(String name) {
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
	public Address setPhoneNumber(String phoneNumber) {
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
	public Address setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * A:国内；B:国外
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
	public Address setRegionType(String regionType) {
		this.regionType=regionType;
		return this;
	}
	
	/**
	 * 获得 地区位置<br>
	 * 东北、华北等
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
	public Address setRegionLocation(String regionLocation) {
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
	public Address setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Address setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public Address setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Address setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public Address setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public Address setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public Address setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Address setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public Address setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public Address setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 订单量<br>
	 * 每年收到的订单数量
	 * @return 订单量
	*/
	public Integer getOrderCount() {
		return orderCount;
	}
	
	/**
	 * 设置 订单量
	 * @param orderCount 订单量
	 * @return 当前对象
	*/
	public Address setOrderCount(Integer orderCount) {
		this.orderCount=orderCount;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Address , 转换好的 Address 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Address , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
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
	 * 克隆当前对象
	*/
	@Transient
	public Address clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Address duplicate(boolean all) {
		com.leefj.webfull.domain.example.meta.AddressMeta.$$proxy$$ inst = new com.leefj.webfull.domain.example.meta.AddressMeta.$$proxy$$();
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setRegionLocation(this.getRegionLocation());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setPhoneNumber(this.getPhoneNumber());
		inst.setDeleted(this.getDeleted());
		inst.setRegionType(this.getRegionType());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setOrderCount(this.getOrderCount());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Address clone(boolean deep) {
		return EntityContext.clone(Address.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Address
	 * @param addressMap 包含实体信息的 Map 对象
	 * @return Address , 转换好的的 Address 对象
	*/
	@Transient
	public static Address createFrom(Map<String,Object> addressMap) {
		if(addressMap==null) return null;
		Address po = create();
		EntityContext.copyProperties(po,addressMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Address
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Address , 转换好的的 Address 对象
	*/
	@Transient
	public static Address createFrom(Object pojo) {
		if(pojo==null) return null;
		Address po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Address，等同于 new
	 * @return Address 对象
	*/
	@Transient
	public static Address create() {
		return new com.leefj.webfull.domain.example.meta.AddressMeta.$$proxy$$();
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
			this.setAddress(DataParser.parse(String.class, map.get(AddressMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(AddressMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AddressMeta.UPDATE_TIME)));
			this.setRegionLocation(DataParser.parse(String.class, map.get(AddressMeta.REGION_LOCATION)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AddressMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AddressMeta.CREATE_BY)));
			this.setPhoneNumber(DataParser.parse(String.class, map.get(AddressMeta.PHONE_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AddressMeta.DELETED)));
			this.setRegionType(DataParser.parse(String.class, map.get(AddressMeta.REGION_TYPE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AddressMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AddressMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AddressMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AddressMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AddressMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AddressMeta.ID)));
			// others
			this.setOrderCount(DataParser.parse(Integer.class, map.get(AddressMeta.ORDER_COUNT)));
			return true;
		} else {
			try {
				this.setAddress( (String)map.get(AddressMeta.ADDRESS));
				this.setNotes( (String)map.get(AddressMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AddressMeta.UPDATE_TIME));
				this.setRegionLocation( (String)map.get(AddressMeta.REGION_LOCATION));
				this.setVersion( (Integer)map.get(AddressMeta.VERSION));
				this.setCreateBy( (String)map.get(AddressMeta.CREATE_BY));
				this.setPhoneNumber( (String)map.get(AddressMeta.PHONE_NUMBER));
				this.setDeleted( (Integer)map.get(AddressMeta.DELETED));
				this.setRegionType( (String)map.get(AddressMeta.REGION_TYPE));
				this.setCreateTime( (Date)map.get(AddressMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AddressMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AddressMeta.DELETE_TIME));
				this.setName( (String)map.get(AddressMeta.NAME));
				this.setDeleteBy( (String)map.get(AddressMeta.DELETE_BY));
				this.setId( (String)map.get(AddressMeta.ID));
				// others
				this.setOrderCount( (Integer)map.get(AddressMeta.ORDER_COUNT));
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
			this.setAddress(DataParser.parse(String.class, r.getValue(AddressMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AddressMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AddressMeta.UPDATE_TIME)));
			this.setRegionLocation(DataParser.parse(String.class, r.getValue(AddressMeta.REGION_LOCATION)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AddressMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AddressMeta.CREATE_BY)));
			this.setPhoneNumber(DataParser.parse(String.class, r.getValue(AddressMeta.PHONE_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AddressMeta.DELETED)));
			this.setRegionType(DataParser.parse(String.class, r.getValue(AddressMeta.REGION_TYPE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AddressMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AddressMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AddressMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AddressMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AddressMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AddressMeta.ID)));
			return true;
		} else {
			try {
				this.setAddress( (String)r.getValue(AddressMeta.ADDRESS));
				this.setNotes( (String)r.getValue(AddressMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AddressMeta.UPDATE_TIME));
				this.setRegionLocation( (String)r.getValue(AddressMeta.REGION_LOCATION));
				this.setVersion( (Integer)r.getValue(AddressMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AddressMeta.CREATE_BY));
				this.setPhoneNumber( (String)r.getValue(AddressMeta.PHONE_NUMBER));
				this.setDeleted( (Integer)r.getValue(AddressMeta.DELETED));
				this.setRegionType( (String)r.getValue(AddressMeta.REGION_TYPE));
				this.setCreateTime( (Date)r.getValue(AddressMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AddressMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AddressMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AddressMeta.NAME));
				this.setDeleteBy( (String)r.getValue(AddressMeta.DELETE_BY));
				this.setId( (String)r.getValue(AddressMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}