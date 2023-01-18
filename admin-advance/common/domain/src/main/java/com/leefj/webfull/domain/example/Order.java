package com.leefj.webfull.domain.example;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.leefj.webfull.constants.db.WebFullTables.WEBFULL_EXAMPLE_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.leefj.webfull.domain.example.meta.OrderMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 订单
 * <p>订单 , 数据表 webfull_example_order 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:17
 * @sign 7B9254E3F571BFC7A4E5E63DB311DF60
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "webfull_example_order")
@ApiModel(description = "订单 ; 订单 , 数据表 webfull_example_order 的PO类型")
public class Order extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WEBFULL_EXAMPLE_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "583028022102200320")
	private String id;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号" , example = "1123")
	private String orderNo;
	
	/**
	 * 订单金额：订单金额
	*/
	@ApiModelProperty(required = false,value="订单金额" , notes = "订单金额" , example = "56.00")
	private BigDecimal amount;
	
	/**
	 * 收件地址ID：收件地址ID
	*/
	@ApiModelProperty(required = false,value="收件地址ID" , notes = "收件地址ID" , example = "583028267108274176")
	private String addressId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-05-28 08:25:13")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 收件地址：关联的收件地址对象
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "关联的收件地址对象")
	private Address address;
	
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
	public Order setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getOrderNo() {
		return orderNo;
	}
	
	/**
	 * 设置 订单编号
	 * @param orderNo 订单编号
	 * @return 当前对象
	*/
	public Order setOrderNo(String orderNo) {
		this.orderNo=orderNo;
		return this;
	}
	
	/**
	 * 获得 订单金额<br>
	 * 订单金额
	 * @return 订单金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 订单金额
	 * @param amount 订单金额
	 * @return 当前对象
	*/
	public Order setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 收件地址ID<br>
	 * 收件地址ID
	 * @return 收件地址ID
	*/
	public String getAddressId() {
		return addressId;
	}
	
	/**
	 * 设置 收件地址ID
	 * @param addressId 收件地址ID
	 * @return 当前对象
	*/
	public Order setAddressId(String addressId) {
		this.addressId=addressId;
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
	public Order setCreateBy(String createBy) {
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
	public Order setCreateTime(Date createTime) {
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
	public Order setUpdateBy(String updateBy) {
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
	public Order setUpdateTime(Date updateTime) {
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
	public Order setDeleted(Integer deleted) {
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
	public Order setDeleted(Boolean deletedBool) {
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
	public Order setDeleteBy(String deleteBy) {
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
	public Order setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public Order setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 关联的收件地址对象
	 * @return 收件地址
	*/
	public Address getAddress() {
		return address;
	}
	
	/**
	 * 设置 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public Order setAddress(Address address) {
		this.address=address;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Order , 转换好的 Order 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Order , 转换好的 PoJo 对象
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
	public Order clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Order duplicate(boolean all) {
		com.leefj.webfull.domain.example.meta.OrderMeta.$$proxy$$ inst = new com.leefj.webfull.domain.example.meta.OrderMeta.$$proxy$$();
		inst.setAmount(this.getAmount());
		inst.setCreateBy(this.getCreateBy());
		inst.setOrderNo(this.getOrderNo());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.setAddressId(this.getAddressId());
		if(all) {
			inst.setAddress(this.getAddress());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Order clone(boolean deep) {
		return EntityContext.clone(Order.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Order
	 * @param orderMap 包含实体信息的 Map 对象
	 * @return Order , 转换好的的 Order 对象
	*/
	@Transient
	public static Order createFrom(Map<String,Object> orderMap) {
		if(orderMap==null) return null;
		Order po = create();
		EntityContext.copyProperties(po,orderMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Order
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Order , 转换好的的 Order 对象
	*/
	@Transient
	public static Order createFrom(Object pojo) {
		if(pojo==null) return null;
		Order po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Order，等同于 new
	 * @return Order 对象
	*/
	@Transient
	public static Order create() {
		return new com.leefj.webfull.domain.example.meta.OrderMeta.$$proxy$$();
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
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(OrderMeta.AMOUNT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(OrderMeta.CREATE_BY)));
			this.setOrderNo(DataParser.parse(String.class, map.get(OrderMeta.ORDER_NO)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(OrderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(OrderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(OrderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(OrderMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(OrderMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(OrderMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(OrderMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(OrderMeta.VERSION)));
			this.setAddressId(DataParser.parse(String.class, map.get(OrderMeta.ADDRESS_ID)));
			// others
			this.setAddress(DataParser.parse(Address.class, map.get(OrderMeta.ADDRESS)));
			return true;
		} else {
			try {
				this.setAmount( (BigDecimal)map.get(OrderMeta.AMOUNT));
				this.setCreateBy( (String)map.get(OrderMeta.CREATE_BY));
				this.setOrderNo( (String)map.get(OrderMeta.ORDER_NO));
				this.setDeleted( (Integer)map.get(OrderMeta.DELETED));
				this.setCreateTime( (Date)map.get(OrderMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(OrderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(OrderMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(OrderMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(OrderMeta.UPDATE_TIME));
				this.setId( (String)map.get(OrderMeta.ID));
				this.setVersion( (Integer)map.get(OrderMeta.VERSION));
				this.setAddressId( (String)map.get(OrderMeta.ADDRESS_ID));
				// others
				this.setAddress( (Address)map.get(OrderMeta.ADDRESS));
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
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(OrderMeta.AMOUNT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(OrderMeta.CREATE_BY)));
			this.setOrderNo(DataParser.parse(String.class, r.getValue(OrderMeta.ORDER_NO)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(OrderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(OrderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(OrderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(OrderMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(OrderMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(OrderMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(OrderMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(OrderMeta.VERSION)));
			this.setAddressId(DataParser.parse(String.class, r.getValue(OrderMeta.ADDRESS_ID)));
			return true;
		} else {
			try {
				this.setAmount( (BigDecimal)r.getValue(OrderMeta.AMOUNT));
				this.setCreateBy( (String)r.getValue(OrderMeta.CREATE_BY));
				this.setOrderNo( (String)r.getValue(OrderMeta.ORDER_NO));
				this.setDeleted( (Integer)r.getValue(OrderMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(OrderMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(OrderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(OrderMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(OrderMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(OrderMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(OrderMeta.ID));
				this.setVersion( (Integer)r.getValue(OrderMeta.VERSION));
				this.setAddressId( (String)r.getValue(OrderMeta.ADDRESS_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}