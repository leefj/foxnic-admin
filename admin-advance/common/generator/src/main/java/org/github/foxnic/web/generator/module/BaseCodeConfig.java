package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.util.ModuleCodeConfig;
import com.github.foxnic.sql.meta.DBTable;
import com.leefj.webfull.proxy.WebFullServiceNames;
import org.github.foxnic.web.generator.config.WebFullConfigs;
import org.github.foxnic.web.generator.config.WebFullConfigs.ProjectConfigs;

public abstract class BaseCodeConfig<T extends DBTable> extends ModuleCodeConfig<T> {


    private WebFullConfigs configs;



    public BaseCodeConfig(String appConfigPrefix, T table, String tablePrefix) {
        super(table,tablePrefix);
        this.configs=new WebFullConfigs(appConfigPrefix);
        this.init();
    }



    @Override
    protected ModuleContext createModuleContext() {
        return createModuleConfig();
    }

    protected ModuleContext createModuleConfig() {

        //项目配置
        ProjectConfigs procfg=this.configs.getProjectConfigs();

        ModuleContext mdu=new ModuleContext(this.configs.getSettings(),TABLE,tablePrefix,procfg.getAppPackageName());
        //设置页面的代码文件路径
        mdu.setViewPrefixPath(procfg.getAppViewPrefixPath());
        //设置页面访问的基础URI
        mdu.setViewPrefixURI(procfg.getAppViewPrefixURI());
        //设置 DAO
        mdu.setDAO(this.configs.getDAO());
        //设置 Domain Project
        mdu.setDomainProject(this.configs.getDomainProject());
        //设置 Proxy Project
        mdu.setProxyProject(this.configs.getProxyProject());
        //设置 Service Project
        mdu.setServiceProject(this.configs.getServiceProject());
        //设置 View Project
        mdu.setViewProject(this.configs.getViewProject());
        //设置 Wrapper Project
        mdu.setWrapperProject(this.configs.getWrapperProject());
        //设置DAO名称常量
        mdu.setDAONameConsts(procfg.getDAONameConst());
        //设置微服务命名常量
        mdu.setMicroServiceNameConst(WebFullServiceNames.class.getName()+"."+procfg.getAppMicroServiceNameConst());

        return mdu;

    }

}
