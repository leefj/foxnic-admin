package com.leefj.webfull.domain.example;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.leefj.webfull.constants.db.WebFullTables.WEBFULL_EXAMPLE_REIMBURSEMENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.leefj.webfull.domain.example.meta.ReimbursementMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 费用报销单
 * <p>费用报销单 , 数据表 webfull_example_reimbursement 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:18
 * @sign 5B0C5700DE3EF0CA0F21FF0A29C56507
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "webfull_example_reimbursement")
@ApiModel(description = "费用报销单 ; 费用报销单 , 数据表 webfull_example_reimbursement 的PO类型")
public class Reimbursement extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WEBFULL_EXAMPLE_REIMBURSEMENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "643103860822376448")
	private Long id;
	
	/**
	 * 费用名称：费用名称
	*/
	@ApiModelProperty(required = false,value="费用名称" , notes = "费用名称" , example = "机票")
	private String title;
	
	/**
	 * 报销金额：报销金额
	*/
	@ApiModelProperty(required = false,value="报销金额" , notes = "报销金额" , example = "200.00")
	private BigDecimal amount;
	
	/**
	 * 审批状态：审批状态
	*/
	@ApiModelProperty(required = false,value="审批状态" , notes = "审批状态" , example = "审批中")
	private String status;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "581798649130909696")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-11-10 03:05:09")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "581798649130909696")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-11-10 03:57:56")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public Reimbursement setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 费用名称<br>
	 * 费用名称
	 * @return 费用名称
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 费用名称
	 * @param title 费用名称
	 * @return 当前对象
	*/
	public Reimbursement setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 报销金额<br>
	 * 报销金额
	 * @return 报销金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 报销金额
	 * @param amount 报销金额
	 * @return 当前对象
	*/
	public Reimbursement setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 审批状态<br>
	 * 审批状态
	 * @return 审批状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 审批状态
	 * @param status 审批状态
	 * @return 当前对象
	*/
	public Reimbursement setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public Reimbursement setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public Reimbursement setCreateBy(String createBy) {
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
	public Reimbursement setCreateTime(Date createTime) {
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
	public Reimbursement setUpdateBy(String updateBy) {
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
	public Reimbursement setUpdateTime(Date updateTime) {
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
	public Reimbursement setDeleted(Integer deleted) {
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
	public Reimbursement setDeleted(Boolean deletedBool) {
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
	public Reimbursement setDeleteBy(String deleteBy) {
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
	public Reimbursement setDeleteTime(Date deleteTime) {
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
	public Reimbursement setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public Reimbursement setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public Reimbursement addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public Reimbursement setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public Reimbursement addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public Reimbursement setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Reimbursement , 转换好的 Reimbursement 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Reimbursement , 转换好的 PoJo 对象
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
	public Reimbursement clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Reimbursement duplicate(boolean all) {
		com.leefj.webfull.domain.example.meta.ReimbursementMeta.$$proxy$$ inst = new com.leefj.webfull.domain.example.meta.ReimbursementMeta.$$proxy$$();
		inst.setAmount(this.getAmount());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Reimbursement clone(boolean deep) {
		return EntityContext.clone(Reimbursement.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Reimbursement
	 * @param reimbursementMap 包含实体信息的 Map 对象
	 * @return Reimbursement , 转换好的的 Reimbursement 对象
	*/
	@Transient
	public static Reimbursement createFrom(Map<String,Object> reimbursementMap) {
		if(reimbursementMap==null) return null;
		Reimbursement po = create();
		EntityContext.copyProperties(po,reimbursementMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Reimbursement
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Reimbursement , 转换好的的 Reimbursement 对象
	*/
	@Transient
	public static Reimbursement createFrom(Object pojo) {
		if(pojo==null) return null;
		Reimbursement po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Reimbursement，等同于 new
	 * @return Reimbursement 对象
	*/
	@Transient
	public static Reimbursement create() {
		return new com.leefj.webfull.domain.example.meta.ReimbursementMeta.$$proxy$$();
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
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(ReimbursementMeta.AMOUNT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ReimbursementMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(ReimbursementMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ReimbursementMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ReimbursementMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ReimbursementMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ReimbursementMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ReimbursementMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ReimbursementMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ReimbursementMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ReimbursementMeta.DELETE_BY)));
			this.setId(DataParser.parse(Long.class, map.get(ReimbursementMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(ReimbursementMeta.STATUS)));
			// others
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(ReimbursementMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setAmount( (BigDecimal)map.get(ReimbursementMeta.AMOUNT));
				this.setUpdateTime( (Date)map.get(ReimbursementMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(ReimbursementMeta.TITLE));
				this.setVersion( (Integer)map.get(ReimbursementMeta.VERSION));
				this.setCreateBy( (String)map.get(ReimbursementMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ReimbursementMeta.DELETED));
				this.setCreateTime( (Date)map.get(ReimbursementMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ReimbursementMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ReimbursementMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ReimbursementMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ReimbursementMeta.DELETE_BY));
				this.setId( (Long)map.get(ReimbursementMeta.ID));
				this.setStatus( (String)map.get(ReimbursementMeta.STATUS));
				// others
				this.setDefaultProcess( (ProcessInstance)map.get(ReimbursementMeta.DEFAULT_PROCESS));
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
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(ReimbursementMeta.AMOUNT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ReimbursementMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(ReimbursementMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ReimbursementMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ReimbursementMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ReimbursementMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ReimbursementMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ReimbursementMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ReimbursementMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ReimbursementMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ReimbursementMeta.DELETE_BY)));
			this.setId(DataParser.parse(Long.class, r.getValue(ReimbursementMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(ReimbursementMeta.STATUS)));
			return true;
		} else {
			try {
				this.setAmount( (BigDecimal)r.getValue(ReimbursementMeta.AMOUNT));
				this.setUpdateTime( (Date)r.getValue(ReimbursementMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(ReimbursementMeta.TITLE));
				this.setVersion( (Integer)r.getValue(ReimbursementMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ReimbursementMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ReimbursementMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ReimbursementMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ReimbursementMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ReimbursementMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ReimbursementMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ReimbursementMeta.DELETE_BY));
				this.setId( (Long)r.getValue(ReimbursementMeta.ID));
				this.setStatus( (String)r.getValue(ReimbursementMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}