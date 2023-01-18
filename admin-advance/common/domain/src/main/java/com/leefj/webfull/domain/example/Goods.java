package com.leefj.webfull.domain.example;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.leefj.webfull.constants.db.WebFullTables.WEBFULL_EXAMPLE_GOODS;
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
import com.leefj.webfull.domain.example.meta.GoodsMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 商品
 * <p>商品 , 数据表 webfull_example_goods 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:16
 * @sign C98473D743B459B0685316BD1117E3A3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "webfull_example_goods")
@ApiModel(description = "商品 ; 商品 , 数据表 webfull_example_goods 的PO类型")
public class Goods extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WEBFULL_EXAMPLE_GOODS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "583020505427087360")
	private String id;
	
	/**
	 * 商品名：商品名
	*/
	@ApiModelProperty(required = false,value="商品名" , notes = "商品名" , example = "苹果")
	private String name;
	
	/**
	 * 单价：单价
	*/
	@ApiModelProperty(required = false,value="单价" , notes = "单价" , example = "6.00")
	private BigDecimal price;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-05-28 07:55:20")
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
	public Goods setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 商品名<br>
	 * 商品名
	 * @return 商品名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 商品名
	 * @param name 商品名
	 * @return 当前对象
	*/
	public Goods setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 单价<br>
	 * 单价
	 * @return 单价
	*/
	public BigDecimal getPrice() {
		return price;
	}
	
	/**
	 * 设置 单价
	 * @param price 单价
	 * @return 当前对象
	*/
	public Goods setPrice(BigDecimal price) {
		this.price=price;
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
	public Goods setCreateBy(String createBy) {
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
	public Goods setCreateTime(Date createTime) {
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
	public Goods setUpdateBy(String updateBy) {
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
	public Goods setUpdateTime(Date updateTime) {
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
	public Goods setDeleted(Integer deleted) {
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
	public Goods setDeleted(Boolean deletedBool) {
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
	public Goods setDeleteBy(String deleteBy) {
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
	public Goods setDeleteTime(Date deleteTime) {
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
	public Goods setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Goods , 转换好的 Goods 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Goods , 转换好的 PoJo 对象
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
	public Goods clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Goods duplicate(boolean all) {
		com.leefj.webfull.domain.example.meta.GoodsMeta.$$proxy$$ inst = new com.leefj.webfull.domain.example.meta.GoodsMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setPrice(this.getPrice());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Goods clone(boolean deep) {
		return EntityContext.clone(Goods.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Goods
	 * @param goodsMap 包含实体信息的 Map 对象
	 * @return Goods , 转换好的的 Goods 对象
	*/
	@Transient
	public static Goods createFrom(Map<String,Object> goodsMap) {
		if(goodsMap==null) return null;
		Goods po = create();
		EntityContext.copyProperties(po,goodsMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Goods
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Goods , 转换好的的 Goods 对象
	*/
	@Transient
	public static Goods createFrom(Object pojo) {
		if(pojo==null) return null;
		Goods po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Goods，等同于 new
	 * @return Goods 对象
	*/
	@Transient
	public static Goods create() {
		return new com.leefj.webfull.domain.example.meta.GoodsMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(GoodsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(GoodsMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(GoodsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(GoodsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(GoodsMeta.DELETE_TIME)));
			this.setPrice(DataParser.parse(BigDecimal.class, map.get(GoodsMeta.PRICE)));
			this.setName(DataParser.parse(String.class, map.get(GoodsMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(GoodsMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(GoodsMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(GoodsMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(GoodsMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(GoodsMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(GoodsMeta.DELETED));
				this.setCreateTime( (Date)map.get(GoodsMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(GoodsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(GoodsMeta.DELETE_TIME));
				this.setPrice( (BigDecimal)map.get(GoodsMeta.PRICE));
				this.setName( (String)map.get(GoodsMeta.NAME));
				this.setDeleteBy( (String)map.get(GoodsMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(GoodsMeta.UPDATE_TIME));
				this.setId( (String)map.get(GoodsMeta.ID));
				this.setVersion( (Integer)map.get(GoodsMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(GoodsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(GoodsMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(GoodsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(GoodsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(GoodsMeta.DELETE_TIME)));
			this.setPrice(DataParser.parse(BigDecimal.class, r.getValue(GoodsMeta.PRICE)));
			this.setName(DataParser.parse(String.class, r.getValue(GoodsMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(GoodsMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(GoodsMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(GoodsMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(GoodsMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(GoodsMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(GoodsMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(GoodsMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(GoodsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(GoodsMeta.DELETE_TIME));
				this.setPrice( (BigDecimal)r.getValue(GoodsMeta.PRICE));
				this.setName( (String)r.getValue(GoodsMeta.NAME));
				this.setDeleteBy( (String)r.getValue(GoodsMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(GoodsMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(GoodsMeta.ID));
				this.setVersion( (Integer)r.getValue(GoodsMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}