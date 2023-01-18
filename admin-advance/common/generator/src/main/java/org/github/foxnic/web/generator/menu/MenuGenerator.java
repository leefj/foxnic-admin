package org.github.foxnic.web.generator.menu;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.business.ControllerProxyFile;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBType;
import com.leefj.webfull.constants.db.WebFullTables;
import com.leefj.webfull.example.page.*;
import com.leefj.webfull.proxy.example.*;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.AccessType;
import org.github.foxnic.web.constants.enums.system.MenuType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuResource;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.generator.config.WebFullConfigs;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuGenerator {

	/**
	 * 超级管理员角色ID
	 * */
	public static final String SUPER_ADMIN_ROLE_ID="110352963290923110";

	public static void main(String[] args) {


		MenuGenerator mg=null;

//		mg=new MenuGenerator(ExampleTables.EXAMPLE_ORDER.$TABLE, OrderServiceProxy.class, OrderPageController.class);
//		mg.generate("583014848745439232");

//		mg=new MenuGenerator(ExampleTables.EXAMPLE_ORDER_ITEM.$TABLE, OrderItemServiceProxy.class, OrderItemPageController.class);
//		mg.generate("583014848745439232");

//		mg=new MenuGenerator(ExampleTables.EXAMPLE_GOODS.$TABLE, GoodsServiceProxy.class, GoodsPageController.class);
//		mg.generate("583014848745439232");

//		mg=new MenuGenerator(WebFullTables.WEBFULL_EXAMPLE_ADDRESS.$TABLE, AddressServiceProxy.class, AddressPageController.class);
//		mg=new MenuGenerator(WebFullTables.WEBFULL_EXAMPLE_GOODS.$TABLE, GoodsServiceProxy.class, GoodsPageController.class);
//		mg=new MenuGenerator(WebFullTables.WEBFULL_EXAMPLE_ORDER.$TABLE, OrderServiceProxy.class, OrderPageController.class);
//		mg=new MenuGenerator(WebFullTables.WEBFULL_EXAMPLE_ORDER_ITEM.$TABLE, OrderItemServiceProxy.class, OrderItemPageController.class);
		mg=new MenuGenerator(WebFullTables.WEBFULL_EXAMPLE_REIMBURSEMENT.$TABLE, ReimbursementServiceProxy.class, ReimbursementPageController.class);
		mg.generate("643084271635922944");
		// mg.removeByBatchId("608188281577799680");

//		mg=new MenuGenerator(FoxnicWeb.BPM_PROCESS_DEFINITION.$TABLE, ProcessDefinitionServiceProxy.class, ProcessDefinitionPageController.class);
//		mg.generate("555766790999773184");

//		mg=new MenuGenerator(FoxnicWeb.BPM_EVENT_CALLBACK.$TABLE, EventCallbackServiceProxy.class, EventCallbackPageController.class);
//		mg.generate("578497780117409792");

//		mg=new MenuGenerator(FoxnicWeb.BPM_PROCESS_ERROR.$TABLE, ProcessErrorServiceProxy.class, ProcessErrorPageController.class);
//		mg.generate("578497780117409792");

//		mg.removeByBatchId("583019436554846208");


//		mg=new MenuGenerator(FoxnicWeb.BPM_PROCESS_DEFINITION_NODE.$TABLE, ProcessDefinitionNodeServiceProxy.class, ProcessDefinitionNodePageController.class);
//		mg.generate("555766790999773184");



//		mg=new MenuGenerator(FoxnicWeb.BPM_TASK.$TABLE, TaskServiceProxy.class, TaskPageController.class);
//		mg.generate("555766790999773184");

//		mg=new MenuGenerator(FoxnicWeb.BPM_PROCESS_INSTANCE.$TABLE, ProcessInstanceServiceProxy.class, ProcessInstancePageController.class);
//		mg.generate("555766790999773184");

//		mg=new MenuGenerator(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.$TABLE, ProcessDefinitionFileServiceProxy.class, ProcessDefinitionFilePageController.class);
//		mg.generate("555766790999773184");

//		mg=new MenuGenerator(FoxnicWeb.BPM_PROCESS_INITIATOR.$TABLE, ProcessInitiatorServiceProxy.class, ProcessInitiatorPageController.class);
//		mg.generate("555766790999773184");

//		mg=new MenuGenerator(FoxnicWeb.BPM_FORM_DEFINITION.$TABLE, FormDefinitionServiceProxy.class, FormDefinitionPageController.class);
//		mg.generate("555766790999773184");

//		mg=new MenuGenerator(FoxnicWeb.BPM_DEMO_LEAVE.$TABLE, DemoLeaveServiceProxy.class, DemoLeavePageController.class);
//		mg.generate("495201409763901440");

//		mg = new MenuGenerator(FoxnicWeb.BPM_DEMO_COMMON.$TABLE, DemoCommonServiceProxy.class, DemoCommonPageController.class);
//		mg.generate("495201409763901440");

		// 生成菜单
//		mg=new MenuGenerator(ExampleTables.EXAMPLE_NEWS.$TABLE, NewsServiceProxy.class, NewsPageController.class);
//		mg.generate("495201409763901440");
//		// 按生成的 batchId 删除菜单
//		mg.removeByBatchId("554044697505431552");




//		mg=new MenuGenerator(FoxnicWeb.SYS_JOB_LOG.$TABLE, JobLogServiceProxy.class, JobLogPageController.class);
//		mg.generate("530778450735136769");

//		mg=new MenuGenerator(FoxnicWeb.SYS_JOB_WORKER.$TABLE, JobWorkerServiceProxy.class, JobWorkerPageController.class);
//		mg.generate("530778450735136769");

//		mg=new MenuGenerator(FoxnicWeb.SYS_JOB.$TABLE, JobServiceProxy.class, JobPageController.class);
//		mg.generate("530778450735136769");


//		mg=new MenuGenerator(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.$TABLE, BusiRoleMemberServiceProxy.class, BusiRoleMemberPageController.class);
//		mg.generate("oauth");




//		mg.removeByBatchId("501070741601517568");



//		mg=new MenuGenerator(FoxnicWeb.DP_RULE_CONDITION.$TABLE, RuleConditionServiceProxy.class, RuleConditionPageController.class);
//		mg.generate("501068138247360512");

//		mg=new MenuGenerator(FoxnicWeb.DP_RULE_RANGE.$TABLE, RuleRangeServiceProxy.class, RuleRangePageController.class);
//		mg.generate("501068138247360512");

//		mg=new MenuGenerator(FoxnicWeb.DP_RULE.$TABLE, RuleServiceProxy.class, RulePageController.class);
//		mg.generate("501068138247360512");

//		mg=new MenuGenerator(FoxnicWeb.DP_SUBJECT_PROPERTY.$TABLE, SubjectPropertyServiceProxy.class, SubjectPropertyPageController.class);
//		mg.generate("501068138247360512");

		//资源
//		mg=new MenuGenerator(SYS_RESOURZE.$TABLE,ResourzeServiceProxy.class, ResourzePageController.class);
//		mg.generate("oauth");

//		mg=new MenuGenerator(SYS_MENU.$TABLE, MenuServiceProxy.class, MenuPageController.class);
//		mg.generate("oauth");

//		mg=new MenuGenerator(SYS_ROLE.$TABLE, RoleServiceProxy.class, RolePageController.class);
//		mg.generate("oauth");

//		mg=new MenuGenerator(SYS_USER.$TABLE, UserServiceProxy.class, UserPageController.class);
//		mg.generate("oauth");

//		mg=new MenuGenerator(FoxnicWeb.SYS_CONFIG.$TABLE, ConfigServiceProxy.class, ConfigPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_LANG.$TABLE, LangServiceProxy.class, LangPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_DICT.$TABLE, DictServiceProxy.class, DictPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_SESSION_ONLINE.$TABLE, SessionOnlineServiceProxy.class, SessionOnlinePageController.class);
//		mg.generate("463397133957988354");

//		mg=new MenuGenerator(FoxnicWeb.SYS_FILE.$TABLE, FileServiceProxy.class, FilePageController.class);
//		mg.generate("463397133957988354");
//		mg.grantAll();

//		mg=new MenuGenerator(FoxnicWeb.SYS_DB_CACHE.$TABLE, DbCacheServiceProxy.class, DbCachePageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_DICT_ITEM.$TABLE, DictItemServiceProxy.class, DictItemPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_CODE_EXAMPLE.$TABLE, CodeExampleServiceProxy.class, CodeExamplePageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_NODE.$TABLE, NodeServiceProxy.class, NodePageController.class);
//		mg.generate("463397133957988354");

//		mg=new MenuGenerator(FoxnicWeb.SYS_CODE_EXAMPLE_CAR.$TABLE, CodeExampleCarServiceProxy.class, CodeExampleCarPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.HRM_PERSON.$TABLE, PersonServiceProxy.class, PersonPageController.class);
//		mg.generate("hrm");

//		mg=new MenuGenerator(FoxnicWeb.HRM_EMPLOYEE.$TABLE, EmployeeServiceProxy.class, EmployeePageController.class);
//		mg.generate("hrm");

//		mg=new MenuGenerator(FoxnicWeb.SYS_TENANT.$TABLE, TenantServiceProxy.class, TenantPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.SYS_USER_TENANT.$TABLE, UserTenantServiceProxy.class, UserTenantPageController.class);
//		mg.generate("system_config");

//		mg=new MenuGenerator(FoxnicWeb.HRM_COMPANY.$TABLE, CompanyServiceProxy.class, CompanyPageController.class);
//		mg.generate("hrm");


//		mg=new MenuGenerator(FoxnicWeb.PCM_CATALOG.$TABLE, CatalogServiceProxy.class, CatalogPageController.class);
//		mg.generate("484683104078794753");

//		mg=new MenuGenerator(FoxnicWeb.PCM_CATALOG_ATTRIBUTE.$TABLE, CatalogAttributeServiceProxy.class, CatalogAttributePageController.class);
//		mg.generate("484683104078794753");



//		mg=new MenuGenerator(FoxnicWeb.SYS_SEQUENCE.$TABLE, SequenceServiceProxy.class, SequencePageController.class);
//		mg.generate("system_config");


//		mg=new MenuGenerator(FoxnicWeb.HRM_ORGANIZATION.$TABLE, OrganizationServiceProxy.class, OrganizationPageController.class);
//		mg.generate("hrm");

//		mg=new MenuGenerator(FoxnicWeb.HRM_POSITION.$TABLE, PositionServiceProxy.class, PositionPageController.class);
//		mg.generate("hrm");


//		mg=new MenuGenerator(FoxnicWeb.CHS_CHANGE_DEFINITION.$TABLE, ChangeDefinitionServiceProxy.class, ChangeDefinitionPageController.class);
//		mg.generate("494903523763298304");

//		mg=new MenuGenerator(FoxnicWeb.CHS_CHANGE_INSTANCE.$TABLE, ChangeInstanceServiceProxy.class, ChangeInstancePageController.class);
//		mg.generate("494903523763298304");

//		mg=new MenuGenerator(FoxnicWeb.CHS_EXAMPLE_ORDER.$TABLE, ExampleOrderServiceProxy.class, ExampleOrderPageController.class);
//		mg.generate("495201409763901440");

//		mg=new MenuGenerator(FoxnicWeb.CHS_EXAMPLE_ORDER_ITEM.$TABLE, ExampleOrderItemServiceProxy.class, ExampleOrderItemPageController.class);
//		mg.generate("495201409763901440");


//		mg=new MenuGenerator(FoxnicWeb.BPM_ROLE.$TABLE, RoleServiceProxy.class, RolePageController.class);
//		mg.generate("494903523763298304");

//		mg=new MenuGenerator(FoxnicWeb.BPM_ROLE_EMPLOYEE.$TABLE, RoleEmployeeServiceProxy.class, RoleEmployeePageController.class);
//		mg.generate("494903523763298304");

//		mg=new MenuGenerator(FoxnicWeb.DP_SUBJECT.$TABLE, SubjectServiceProxy.class, SubjectPageController.class);
//		mg.generate("501068138247360512");




	}








	private WebFullConfigs configs;
	private DAO dao;
	private DBTable table;
	private Class proxyType;
	private Class pageType;
	//
	private String batchId;
	private Menu topMenu=null;
	private List<Resourze> resourzes=new ArrayList<>();
	private Map<String,Resourze> resourceMap=new HashMap<>();
	private String authorityPrefix;
	private String roleId;

	private MenuGenerator(DBTable table,Class proxyType,Class pageType) {
		this("webfull-service-example",SUPER_ADMIN_ROLE_ID,table,proxyType,pageType);
	}

	public MenuGenerator(String appId,String roleId,DBTable table,Class proxyType,Class pageType) {
		this.configs=new WebFullConfigs(appId);
		this.dao=this.configs.getDAO();
		this.table=table;
		this.proxyType =proxyType;
		this.pageType =pageType;
		this.batchId=IDGenerator.getSnowflakeIdString();
		this.authorityPrefix=table.name().toLowerCase()+":";
		this.roleId=roleId;
		System.err.println("batchId = "+batchId);

	}

	public void grantAll() {
		List<Menu> menus=dao.queryEntities(Menu.class,"SELECT * FROM sys_menu where id not in (SELECT menu_id FROM sys_role_menu)");
		for (Menu menu : menus) {
			RoleMenu rm=new RoleMenu();
			rm.setId(IDGenerator.getSnowflakeIdString());
			rm.setMenuId(menu.getId());
			rm.setRoleId(roleId);
			dao.insertEntity(rm);
		}
	}



	public void generate(String parentId) {

		Menu parent=dao.queryEntity(Menu.create().setId(parentId));
		if(parent==null) {
			System.err.println("上级菜单 ID = "+parentId+" 不存在");
			return;
		}

		dao.execute("delete from "+ FoxnicWeb.SYS_RESOURZE.$NAME +" where deleted=1");

		Rcd m=dao.queryRecord("select batch_id from sys_menu where parent_id=? and label=?",parentId,getTopMenuLabel());

		if(m!=null) {
			batchId=m.getString("batch_id");
			System.err.println("菜单生成失败，同一父节点下已经存在同名菜单"+(batchId==null?"":(" , 已存在菜单的 batchId 为 "+batchId)));
			return;
		}

		try {
			dao.beginTransaction();
			createPageResources();
			createTopMenu(parentId);
			createApiResource();
			createSubMenus();
			refreshHierarchy();
			grant();
			dao.commit();
		} catch (Exception e){
			dao.rollback();
			System.err.println("生成失败，数据已回滚");
			e.printStackTrace();
		}
	}

	private String getTopMenuLabel() {
		return  getTopic()+"管理";
	}

	/**
	 * 刷新层级路径
	 * */
	protected void refreshHierarchy() {

		dao.execute("update sys_menu set hierarchy=id where parent_id is null or trim(parent_id)=''");

		String sql= null;

		if(dao.getDBType()== DBType.MYSQL) {
			sql="UPDATE sys_menu c, sys_menu p " +
					"SET c.hierarchy=CONCAT(p.hierarchy,'/',c.id) " +
					"WHERE p.id=c.parent_id and c.hierarchy is null and p.hierarchy is not null";
		} else if(dao.getDBType()== DBType.DM) {
			sql="UPDATE sys_menu c SET \n" +
					"c.hierarchy=CONCAT((select p.hierarchy from  sys_menu p WHERE p.id=c.parent_id and p.hierarchy is not null),'/',c.id) \n" +
					"where c.hierarchy is null";
		}


		while (true) {
			int i=dao.execute(sql);
			if(i==0) break;
		}


	}

	protected  String getFunctionString() {
		return ControllerProxyFile.CATALOG;
	}


	private void createSubMenus() {
		String[] tmp=getFunctionString().split(";");
		int idx=0;
		for (String s : tmp) {
			String[] line=s.split(":");
			String name=line[0];
			String auth=line[1];
			String[] suffixes=line[2].split(",");
			for (int i = 0; i < suffixes.length; i++) {
				suffixes[i]=suffixes[i].trim();
			}
			Menu menu=new Menu();
			menu.setId(IDGenerator.getSnowflakeIdString());
			menu.setAuthority(authorityPrefix+auth);
			menu.setBatchId(batchId);
			menu.setType(MenuType.function.name());
			menu.setSort(idx);
			menu.setLabel(name);
			menu.setParentId(topMenu.getId());
			menu.setHidden(0);
			idx++;
			//
			dao.insertEntity(menu);

			for (int i = 0; i < suffixes.length; i++) {
				Resourze resourze=resourceMap.get(suffixes[i]);
				if(resourze==null) {
					System.out.println("");
					continue;
				}
				MenuResource mr=new MenuResource();
				mr.setId(IDGenerator.getSnowflakeIdString());
				mr.setMenuId(menu.getId());
				if(resourze.getId()==null) {
					System.out.println("");
				}
				mr.setResourceId(resourze.getId());
				this.dao.insertEntity(mr);
			}

		}

	}

	private void createTopMenu(String parentId) throws Exception {

		for (Resourze resourze : resourzes) {
			if(resourze.getUrl().endsWith("_list.html")) {
				topMenu=new Menu();
				topMenu.setBatchId(batchId);
				topMenu.setId(IDGenerator.getSnowflakeIdString());
				topMenu.setType(MenuType.page.name());
				topMenu.setSort(0);
				topMenu.setUrl("#!"+table.name().toLowerCase()+"_list");
				topMenu.setLabel(getTopMenuLabel());
				topMenu.setHidden(0);
				topMenu.setAuthority(authorityPrefix+"mngr");
				topMenu.setPathResourceId(resourze.getId());
				topMenu.setParentId(parentId);
				dao.insertEntity(topMenu);
				break;
			}
		}

	}



	/**
	 * 从页面控制器提取页面资源
	 * */
	private void createPageResources() throws Exception {

		Field field=null;
		try {
			field=pageType.getDeclaredField("prefix");
		} catch (Exception e) {
			System.err.println(pageType.getName() +" 可能不是一个页面控制器");
			e.printStackTrace();
		}
		String prefix=(String)field.get(null);

		prefix=StringUtil.removeFirst(prefix, "/");

		File file=(new MavenProject(pageType)).getSourceFile(pageType);
		String source= FileUtil.readText(file);
		String[] lines=source.split("\n");

		Method[] ms=pageType.getDeclaredMethods();

		for (Method m : ms) {
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(rm==null) continue;
			String path="/"+StringUtil.joinUrl(prefix,rm.value()[0]);
			System.out.println(path);
			String doc=this.findDoc(m.getName(),source,lines);
			String[] parts=doc.split(" ");
			String name=parts[parts.length-1];
			if(path.endsWith("_list.html")) {
				name="查询页面";
			} else if(path.endsWith("_form.html")) {
				name="表单页面";
			}


			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setName(name);
			resourze.setUrl(path);
			resourze.setType("page");
			resourze.setMethod("GET");
			resourze.setTableName(table.name());
			resourze.setAccessTypeEnum(AccessType.GRANT);
			resourze.setModule(this.getTopic());
			resourze.setBatchId(batchId);

			resourzes.add(resourze);
			if(path.endsWith("_list.html")) {
				resourceMap.put("_list.html",resourze);
			} else if(path.endsWith("_form.html")) {
				resourceMap.put("_form.html",resourze);
			}

			dao.insertEntity(resourze);
		}

	}

	private void createApiResource() throws Exception {

		File file=this.configs.getProxyProject().getSourceFile(proxyType);
		String source= FileUtil.readText(file);
		String[] lines=source.split("\n");


		Field[] fs=proxyType.getDeclaredFields();


		for (Field f : fs) {
			String name=f.getName();
			//排除一些无效的静态属性
			if(name.equals("CONTROLLER_CLASS_NAME") || name.startsWith("API_") ) continue;
			String value=(String)f.get(null);
			String doc=this.findDoc(f.getName(),source,lines);

			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setName(doc);
			resourze.setUrl(value);
			resourze.setType("api");
			resourze.setMethod("POST");
			resourze.setAccessTypeEnum(AccessType.GRANT);
			resourze.setTableName(table.name());
			resourze.setModule(this.getTopic());
			resourze.setBatchId(batchId);

			dao.insertEntity(resourze);

			resourzes.add(resourze);

			value=value.substring(value.lastIndexOf("/"));

			resourceMap.put(value,resourze);

		}
	}


	public String getTopic() {
		DBTableMeta tm=dao.getTableMeta(table.name());
		String topic=tm.getTopic();
		topic=StringUtil.removeLast(topic, "数据表");
		topic=StringUtil.removeLast(topic, "表");
		return  topic;
	}



	private void grant() {

		RcdSet menus=dao.query("select id,label from "+ FoxnicWeb.SYS_MENU.$NAME+" where batch_id=?",batchId);
		for (Rcd r : menus) {
			//导入导出默认不授权
			if( "导入".equals(r.getString("label")) || "导出".equals(r.getString("label"))) continue;
			dao.insert(FoxnicWeb.SYS_ROLE_MENU.$NAME)
			.set(FoxnicWeb.SYS_ROLE_MENU.ID, IDGenerator.getSnowflakeId())
			.set(FoxnicWeb.SYS_ROLE_MENU.ROLE_ID, roleId)
			.set(FoxnicWeb.SYS_ROLE_MENU.MENU_ID, r.getString(FoxnicWeb.SYS_MENU.ID))
			.set(FoxnicWeb.SYS_ROLE_MENU.CREATE_BY,"auto")
			.execute();
		}
	}

	private String findDoc(String name, String source, String[] lines) {
		String line=null;
		int index=-1;
		for (int i = 0; i < lines.length; i++) {
			line=lines[i];
			if(line.contains(" "+name+" ") || line.contains(" "+name+"=")) {
				index=i;
				break;
			}
		}
		if(index==-1) return name;

		String doc=lines[index-2];
		doc=doc.trim();
		doc=StringUtil.removeFirst(doc,"*").trim();
		return doc;
	}

	public void removeByBatchId(String batchId)  {

		if(StringUtil.isBlank(batchId)) {
			throw new RuntimeException("未指定 batchId");
		}

		try {
			this.dao.beginTransaction();
			this.dao.execute("delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id=?)",batchId);
			this.dao.execute("delete from sys_resourze where batch_id=?",batchId);
			this.dao.execute("delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id=?)",batchId);
			this.dao.execute("delete from sys_menu where batch_id=?",batchId);
			this.dao.commit();
		} catch (Exception e) {
			this.dao.rollback();
			e.printStackTrace();;
		}


	}



}
