package com.leefj.webfull.wrapper;

import com.leefj.webfull.framework.WebFullMeta;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {
		// 来自 FoxnicWeb 顶层的功能模块
		FoxnicWebMeta.SERVICE_STORAGE_PACKAGE ,FoxnicWebMeta.SERVICE_JOB_PACKAGE,
		FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE , FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		FoxnicWebMeta.SERVICE_HRM_PACKAGE,FoxnicWebMeta.SERVICE_PCM_PACKAGE,
		FoxnicWebMeta.SERVICE_CHANGES_PACKAGE,
		FoxnicWebMeta.SERVICE_BPM_PACKAGE,
		FoxnicWebMeta.SERVICE_DOCS_PACKAGE,
		FoxnicWebMeta.SERVICE_DATA_PERM_PACKAGE,
		// 自身项目的功能模块
		WebFullMeta.FRAMEWORK_PACKAGE,WebFullMeta.SERVICE_EXAMPLE_PACKAGE
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
public class WebFullApp {

	public static void main(String[] args) {
		BootApplication.run(WebFullApp.class, args);
	}

}
