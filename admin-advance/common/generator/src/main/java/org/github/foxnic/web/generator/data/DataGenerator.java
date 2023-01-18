package org.github.foxnic.web.generator.data;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.network.HttpClient;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeePosition;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.generator.config.WebFullConfigs;

import java.io.File;
import java.util.HashSet;

/**
 * 为以usr_开头的表生成代码
 */
public class DataGenerator  {

	public static void main(String[] args) throws Exception {
		DataGenerator g = new DataGenerator();
		// 按调用顺序呈现
		//
		g.generateEmployees(401);
//		g.generateOrderMeasure(2,9);
//		g.generateOrderMeasure(3,6);
//		g.generateOrderMeasure(4,8);
//		g.generateOrderMeasure(5,12);

//		g.batchAlter();

		//
	}

	private WebFullConfigs configs;
	private DAO dao;

	public DataGenerator() {
		this.configs=new WebFullConfigs("service-example");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 模拟生成量体数据
	 * */
	private void generateEmployees(int limit) {

		MavenProject mp=new MavenProject(this.getClass());
//		File deptFile=FileUtil.resolveByPath(mp.getMainSourceDir(),"com/tailoring/generator/data/dept.txt");
//		String deptText=FileUtil.readText(deptFile);
//		String[] depts=deptText.split("\n");

		String[] posIds=dao.query("select * from hrm_position where deleted=0").getValueArray("id",String.class);


		File empFile=FileUtil.resolveByPath(mp.getMainSourceDir(),"org/github/foxnic/web/generator/data/emp.txt");
		String empText=FileUtil.readText(empFile);
		String[] empLines=empText.split("\n");

		HttpClient client=new HttpClient();

		HashSet<String> names=new HashSet<>();
		BatchParamBuilder pb=new BatchParamBuilder();
		for (int i = 0; i < limit; i++) {
			int z=(int)Math.floor(Math.random()*empLines.length);
			String empln=  empLines[z].trim();
			String[] parts=empln.split("\t");
			if(names.contains(parts[0])) continue;

			Person person=new Person();
			person.setId(IDGenerator.getSnowflakeIdString());
			person.setSource("employee");
			person.setIdentity("330"+IDGenerator.getRandomDigits(16));
			person.setName(parts[0]);
			person.setSex(parts[1]);
			dao.insertEntity(person);

			Employee employee=new Employee();
			employee.setId(IDGenerator.getSnowflakeIdString());
			employee.setPersonId(person.getId());
			employee.setName(parts[0]);
			employee.setPhone("1"+IDGenerator.getRandomDigits(10));
			employee.setCompanyId("002");
			employee.setTenantId("T001");
			employee.setStatus("active");
			dao.insertEntity(employee);
		}

		RcdSet emps=dao.query("SELECT * from hrm_employee e where deleted=0 and not exists(select 1 from hrm_employee_position ep where e.id=ep.employee_id)");
		for (Rcd emp : emps) {
			EmployeePosition ep=new EmployeePosition();
			ep.setId(IDGenerator.getSnowflakeIdString());
			ep.setEmployeeId(emp.getString("id"));
			int z=(int)Math.floor(Math.random()*posIds.length);
			String posId=posIds[z];
			ep.setPositionId(posId);
			dao.insertEntity(ep);
		}

		System.out.println("done");

	}

	/**
	 * 批量修改表
	 * */
	private void batchAlter() {
		String[] tables=dao.getTableNames();
		for (String table : tables) {
//			dao.execute("ALTER TABLE `"+table+"` MODIFY COLUMN `deleted` tinyint(1) NOT NULL DEFAULT b'0' COMMENT '是否已删除' AFTER `update_time`");
			if(dao.getTableColumnMeta(table, "version")!=null) {
				dao.execute("update "+table+" set version=1 where version is null");
				dao.execute("ALTER TABLE "+table+" MODIFY COLUMN version int DEFAULT 1 NOT NULL COMMENT '数据版本号'");
			}

		}
		System.out.println();

	}

}
