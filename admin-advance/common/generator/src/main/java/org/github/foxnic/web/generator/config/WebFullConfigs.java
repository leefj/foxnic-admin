package org.github.foxnic.web.generator.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.foxnic.commons.cache.Variable;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.generator.config.GlobalSettings;
import com.github.foxnic.sql.treaty.DBTreaty;
import com.leefj.webfull.framework.support.datasource.DAOConfig;
import com.leefj.webfull.framework.support.datasource.DatasourceConfig;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.nacos.NacosConfig;
import org.github.foxnic.web.relation.FoxnicWebRelationManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebFullConfigs {

	private String appConfigPrefix;
	private ProjectConfigs projectConfigs;

	protected GlobalSettings settings=null;

	//
	private MavenProject  generatorProject=null;
	private MavenProject domainProject =null;
	private MavenProject serviceProject;
	private MavenProject proxyProject;
	private MavenProject viewProject;
	private MavenProject wrapperProject;

	//
	private String nacosGroup;
	private String nacosDataId;

	//
	private String nacosServerAddr = null;
	private String nacosNamespace=null;
	private String nacosUserName=null;
	private String nacosPassword=null;
	//
	private String datasourceConfigKey=null;
	//
	private YMLProperties applicationConfigs;
	private DAO dao;


	public WebFullConfigs(String appId) {

		System.out.println("machine Id : "+Machine.getIdentity());

		initGlobalSettings();
		//
		generatorProject=new MavenProject(WebFullConfigs.class);


		File configFile=FileUtil.resolveByPath(this.generatorProject.getMainResourceDir(), "config.yml");
		this.appConfigPrefix="applications."+appId;
		projectConfigs=new ProjectConfigs(this.appConfigPrefix,new YMLProperties(configFile));

		File baseDir=generatorProject.getProjectDir().getParentFile().getParentFile();
		File advanceBaseDir=generatorProject.getProjectDir().getParentFile().getParentFile().getParentFile();
		advanceBaseDir=FileUtil.resolveByPath(advanceBaseDir,"foxnic-web-advance");

		//
		File domainProjectFolder=FileUtil.resolveByPath(baseDir, this.projectConfigs.getDomainProjectPath());
		domainProject =new MavenProject(domainProjectFolder);

		if(projectConfigs.isAdvance()) {
			File serviceProjectFolder=FileUtil.resolveByPath(advanceBaseDir,  projectConfigs.getAppServiceProjectPath());
			serviceProject=new MavenProject(serviceProjectFolder);
		} else {
			File serviceProjectFolder=FileUtil.resolveByPath(baseDir,  projectConfigs.getAppServiceProjectPath());
			serviceProject=new MavenProject(serviceProjectFolder);
		}


		File proxyProjectFolder=FileUtil.resolveByPath(baseDir,  this.projectConfigs.getProxyProjectPath());
		proxyProject=new MavenProject(proxyProjectFolder);

		if(projectConfigs.isAdvance()) {
			File viewProjectFolder = FileUtil.resolveByPath(advanceBaseDir, this.projectConfigs.getAppViewProjectPath());
			viewProject = new MavenProject(viewProjectFolder);
		} else {
			File viewProjectFolder = FileUtil.resolveByPath(baseDir, this.projectConfigs.getAppViewProjectPath());
			viewProject = new MavenProject(viewProjectFolder);
		}

		File wrapperProjectFolder=FileUtil.resolveByPath(baseDir,  this.projectConfigs.getAppWrapperProjectPath());
		wrapperProject=new MavenProject(wrapperProjectFolder);


		//????????????
		File bootstrapFile=FileUtil.resolveByPath(this.getWrapperProject().getMainResourceDir(), "bootstrap.yml");
		File applicationFile=FileUtil.resolveByPath(this.getWrapperProject().getMainResourceDir(), "application.yml");

		if(bootstrapFile.exists() && !applicationFile.exists()) {
			YMLProperties bootstrapProperties=new YMLProperties(bootstrapFile);
			nacosServerAddr=bootstrapProperties.getProperty("application.nacos.ip").stringValue();
			nacosUserName=bootstrapProperties.getProperty("application.nacos.username").stringValue();
			nacosPassword=bootstrapProperties.getProperty("application.nacos.password").stringValue();
			nacosNamespace=bootstrapProperties.getProperty("application.nacos.namespace").stringValue();
			this.nacosDataId=this.projectConfigs.getAppNacosDataId();
			this.nacosGroup=this.projectConfigs.getAppNacosGroup();
			File file= this.saveRemoteConfig();
			//????????????
			applicationConfigs=new YMLProperties(file);
		} else if(!bootstrapFile.exists() && applicationFile.exists()) {
			applicationConfigs=new YMLProperties(applicationFile);
		}

		this.datasourceConfigKey=this.projectConfigs.getAppPrimaryDatasourceConfigKey();

		try {
			initDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}


		String author=projectConfigs.getAuthorInfo();

		if(author==null) {
			throw new IllegalArgumentException("??????????????? "+Machine.getIdentity()+" ??????????????????");
		}

		this.settings.setAuthor(author);
		this.settings.setEnableSwagger(projectConfigs.isEnableSwagger());
		this.settings.setEnableMicroService(projectConfigs.isEnableMicroService());
		this.settings.setRebuildEntity(true);

	}


	private void initGlobalSettings() {
		this.settings=new GlobalSettings();
		this.settings.setAuthor("?????????");
	}

	private  static Map<String,DAO> DAOS=new HashMap<>();

	private void initDAO() throws Exception {

		if(dao!=null) return;


		// ?????????????????????

		String prefix=this.getDatasourceConfigKey()+".";
		//
		String driver=applicationConfigs.getProperty(prefix+"driver-class-name").stringValue();
		String url=applicationConfigs.getProperty(prefix+"url").stringValue();
		String username=applicationConfigs.getProperty(prefix+"username").stringValue();
		String password=applicationConfigs.getProperty(prefix+"password").stringValue();



		String key=url+"@"+username;
		dao=DAOS.get(key);
		if(dao!=null) return;

		// ???????????????
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driver);
		ds.setUsername(username);
		ds.setPassword(password);

		DBConfigs.reset(ds, DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY,applicationConfigs);

		dao = (new DAOBuilder()).datasource(ds).build();

		// ?????????????????????
		DBTreaty dbTreaty = (new DAOConfig()).getDBTreaty();
		dao.setDBTreaty(dbTreaty);
		dao.setRelationManager(new FoxnicWebRelationManager());

		DAOS.put(key,dao);
	}

	private File saveRemoteConfig() {
		NacosConfig nacosConfig=new NacosConfig(this.getNacosServerAddr(), this.getNacosNamespace(), this.getNacosUserName(), this.getNacosPassword());
		File file=FileUtil.resolveByPath(this.getGeneratorProject().getMainResourceDir(), "remote",this.getNacosNamespace()+"."+this.nacosGroup+"."+this.nacosDataId);
		nacosConfig.saveConfig(this.nacosDataId, this.nacosGroup, file);
		return file;
	}

	public MavenProject getGeneratorProject() {
		return generatorProject;
	}

	public MavenProject getDomainProject() {
		return domainProject;
	}

	public ProjectConfigs getProjectConfigs() {
		return projectConfigs;
	}

	public MavenProject getViewProject() {
		return viewProject;
	}

	public MavenProject getServiceProject() {
		return serviceProject;
	}



	public MavenProject getProxyProject() {
		return proxyProject;
	}

	public String getNacosServerAddr() {
		return nacosServerAddr;
	}

	public String getNacosNamespace() {
		return nacosNamespace;
	}

	public String getNacosUserName() {
		return nacosUserName;
	}

	public String getNacosPassword() {
		return nacosPassword;
	}

	public String getDatasourceConfigKey() {
		return datasourceConfigKey;
	}

	public DAO getDAO() {
		return dao;
	}

	public GlobalSettings getSettings() {
		return settings;
	}

	public static class ProjectConfigs {
		private YMLProperties properties;
		private String appConfigPrefix;
		public ProjectConfigs(String appConfigPrefix,YMLProperties properties) {
			this.properties=properties;
			this.appConfigPrefix=appConfigPrefix;
		}



		public String getDAONameConst() {
			return properties.getProperty("source.daoNameConst").stringValue();
		}

		/**
		 * ?????? nacos group
		 * */
		public String getAppNacosGroup() {
			return properties.getProperty(this.appConfigPrefix+".nacosGroup").stringValue();
		}

		/**
		 * ?????? nacos group
		 * */
		public String getAppNacosDataId() {
			return properties.getProperty(this.appConfigPrefix+".nacosDataId").stringValue();
		}

		/**
		 * ?????? enableMicroService
		 * */
		public boolean isEnableMicroService() {
			return properties.getProperty("settings.enableMicroService").booleanValue();
		}


		/**
		 * ?????? enableSwagger
		 * */
		public boolean isEnableSwagger() {
			return properties.getProperty("settings.enableSwagger").booleanValue();
		}

		/**
		 * ?????? domain ?????????
		 * */
		public String getDomainProjectPath() {
			return properties.getProperty("compoments.domain").stringValue();
		}

		/**
		 * ?????? proxy ?????????
		 * */
		public String getProxyProjectPath() {
			return properties.getProperty("compoments.proxy").stringValue();
		}

		/**
		 * ?????? domain ?????????
		 * */
		public String getDomainConstantsPackage() {
			return properties.getProperty("source.domainConstantsPackage").stringValue();
		}

		/**
		 * ?????????????????????
		 * */
		public Boolean isAdvance() {
			Boolean advance=properties.getProperty(this.appConfigPrefix+".advance").booleanValue();
			if(advance==null) advance=false;
			return advance;
		}

		/**
		 * ?????????????????????
		 * */
		public String getAppServiceProjectPath() {
			return properties.getProperty(this.appConfigPrefix+".serviceProjectPath").stringValue();
		}

		public String getAppWrapperProjectPath() {
			return properties.getProperty(this.appConfigPrefix+".wrapperProjectPath").stringValue();
		}

		public String getAppPrimaryDatasourceConfigKey() {
			return properties.getProperty(this.appConfigPrefix+".primaryDatasourceConfigKey").stringValue();
		}

		public String getAppMicroServiceNameConst() {
			return properties.getProperty(this.appConfigPrefix+".microServiceNameConst").stringValue();
		}

		public String getAppPackageName() {
			return properties.getProperty(this.appConfigPrefix+".packageName").stringValue();
		}

		public String getAppViewProjectPath() {
			return properties.getProperty(this.appConfigPrefix+".viewProjectPath").stringValue();
		}

		public String getAppViewPrefixPath() {
			return properties.getProperty(this.appConfigPrefix+".viewPrefixPath").stringValue();
		}



		public String getAppViewPrefixURI() {
			String codePathPrefix=this.getAppViewPrefixPath();
			return codePathPrefix.substring(codePathPrefix.indexOf("/"));
		}

		public String getAuthorInfo() {
			Variable var=properties.getProperty("authors."+Machine.getIdentity());
			if(var==null) {
				return null;
			}
			return var.stringValue();
		}





	}

	public MavenProject getWrapperProject() {
		return wrapperProject;
	}



}


