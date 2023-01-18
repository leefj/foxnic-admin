package com.leefj.webfull.wrapper;

import com.leefj.webfull.framework.WebFullMeta;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {
		// 自身项目的功能模块
		WebFullMeta.FRAMEWORK_PACKAGE, FoxnicWebMeta.SERVICE_CAMUNDA_PACKAGE
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
@EnableProcessApplication
public class WebFullBpmApp {

	public static void main(String[] args) {
		BootApplication.run(WebFullBpmApp.class, args);
	}

}
