package com.leefj.webfull.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.leefj.webfull.domain.example.OrderItem;
import java.util.Date;
import com.leefj.webfull.domain.example.Goods;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-11 09:59:17
 * @sign 4B1F7EB11CDE08174CC74090E8224F5F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OrderItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.String> ID_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 订单ID , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 订单ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,ORDER_ID, java.lang.String.class, "订单ID", "订单ID", java.lang.String.class, null);
	
	/**
	 * 商品ID , 类型: java.lang.String
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 商品ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.String> GOODS_ID_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,GOODS_ID, java.lang.String.class, "商品ID", "商品ID", java.lang.String.class, null);
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.Integer> AMOUNT_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,AMOUNT, java.lang.Integer.class, "数量", "数量", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 商品 , 关联的商品 , 类型: com.leefj.webfull.domain.example.Goods
	*/
	public static final String GOODS="goods";
	
	/**
	 * 商品 , 关联的商品 , 类型: com.leefj.webfull.domain.example.Goods
	*/
	public static final BeanProperty<com.leefj.webfull.domain.example.OrderItem,com.leefj.webfull.domain.example.Goods> GOODS_PROP = new BeanProperty(com.leefj.webfull.domain.example.OrderItem.class ,GOODS, com.leefj.webfull.domain.example.Goods.class, "商品", "关联的商品", com.leefj.webfull.domain.example.Goods.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_ID , GOODS_ID , AMOUNT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , GOODS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.leefj.webfull.domain.example.OrderItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public OrderItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单ID
		 * @param orderId 订单ID
		 * @return 当前对象
		*/
		public OrderItem setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 商品ID
		 * @param goodsId 商品ID
		 * @return 当前对象
		*/
		public OrderItem setGoodsId(String goodsId) {
			super.change(GOODS_ID,super.getGoodsId(),goodsId);
			super.setGoodsId(goodsId);
			return this;
		}
		
		/**
		 * 设置 数量
		 * @param amount 数量
		 * @return 当前对象
		*/
		public OrderItem setAmount(Integer amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public OrderItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public OrderItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public OrderItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public OrderItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public OrderItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public OrderItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public OrderItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public OrderItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 商品
		 * @param goods 商品
		 * @return 当前对象
		*/
		public OrderItem setGoods(Goods goods) {
			super.change(GOODS,super.getGoods(),goods);
			super.setGoods(goods);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public OrderItem clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public OrderItem duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAmount(this.getAmount());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setOrderId(this.getOrderId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setGoodsId(this.getGoodsId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setGoods(this.getGoods());
			}
			inst.clearModifies();
			return inst;
		}

	}
}