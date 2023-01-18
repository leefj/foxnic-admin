package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {FoxnicWebMeta.SERVICE_STORAGE_PACKAGE, FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE , FoxnicWebMeta.SERVICE_OAUTH_PACKAGE})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})

public class WrapperAllServiceApp {
	public static void main(String[] args) {
		BootApplication.run(WrapperAllServiceApp.class, args);
	}
}
