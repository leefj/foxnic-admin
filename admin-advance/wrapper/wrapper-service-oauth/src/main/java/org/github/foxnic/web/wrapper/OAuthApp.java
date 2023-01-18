package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { FoxnicWebMeta.SERVICE_OAUTH_PACKAGE })
@SpringBootApplication
public class OAuthApp {
	public static void main(String[] args) {
		CloudApplication.run(OAuthApp.class, args);
	}
	
	 
}
