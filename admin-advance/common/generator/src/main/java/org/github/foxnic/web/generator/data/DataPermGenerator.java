package org.github.foxnic.web.generator.data;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.generator.config.WebFullConfigs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成数据权限模拟场景的数据
 */
public class DataPermGenerator {



	public static void main(String[] args) throws Exception {
		DataPermGenerator g = new DataPermGenerator();
//		g.generateProduct(10);
//		g.updateProduct();
		g.generateOrder(38);

	}

	private WebFullConfigs configs;
	private DAO dao;

	public DataPermGenerator() {
		this.configs=new WebFullConfigs("service-system");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 模拟生成量体数据
	 */
	private void generateOrder(int limit) {
		dao.execute("delete from dp_example_order");
		RcdSet sales = dao.query("SELECT ep.employee_id,p.org_id FROM hrm_position p,hrm_employee_position ep  where p.id=ep.position_id and org_id in(SELECT id FROM `hrm_organization` where hierarchy like '500994919175819264/%') and type='shop_sales'");
		RcdSet products = dao.query("select * from dp_example_product");
		for (Rcd s : sales) {

			for (Rcd p : products) {
				List<SQL> inserts = new ArrayList<>();
				Date d = new Date();
				d = DateUtil.addDays(d, -limit);
				for (int i = 0; i < limit; i++) {
					d = DateUtil.addDays(d, i);
					Double price=p.getDouble("price") *(100- ((20 * Math.random()-10)))/100;
					Long quantity=System.currentTimeMillis()%100;
					Double amount=quantity * price;
					Insert insert = new Insert("dp_example_order");
					insert.set("id", IDGenerator.getSnowflakeIdString()).set("product_id", p.getString("id"))
							.set("shop_id", s.getString("org_id"))
							.set("sales_id", s.getString("employee_id")).set("create_time", d)
							.set("price",price).set("quantity",quantity).set("amount",amount);
					inserts.add(insert);
				}
				System.out.println(inserts.size());
				dao.batchExecute(inserts);
			}
		}
		System.out.println("done");
	}


	/**
	 * 模拟生成量体数据
	 * */
	private void generateProduct(int limit) {
		//查询所有小类
		dao.execute("delete from dp_example_product");
		RcdSet catas=dao.query("select id,parent_id,name from dp_example_catalog where parent_id !='0'");
		RcdSet brands=dao.query("select * from dp_example_brand");
		for (Rcd cata : catas) {
			List<SQL> inserts=new ArrayList<>();
			for (Rcd brand : brands) {
				for (int i = 0; i < 8; i++) {
					Double price= DataParser.parseDouble(IDGenerator.getRandomDigits(3));
					Insert insert=new Insert("dp_example_product");
					insert.set("id", IDGenerator.getSnowflakeIdString()).set("brand_id",brand.getString("id"))
						.set("name",cata.getString("name")+"-"+IDGenerator.getRandomDigits(4))
						.set("big_cata_id",cata.getString("parent_id")).set("sml_cata_id",cata.getString("id")).set("price",price);
					inserts.add(insert);
				}
			}
			dao.batchExecute(inserts);
		}

	}

	private void updateProduct() {
		RcdSet products=dao.query("select * from dp_example_product");
		for (Rcd product : products) {
			Double price= 10 + Math.random() * 60;
			product.set("price",price);
			Update update=SQLBuilder.buildUpdate(product, SaveMode.DIRTY_FIELDS);
			dao.execute(update);
		}
	}


}
