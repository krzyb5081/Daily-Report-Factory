package com.krzyb5081.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		//registry.addViewController("/login").setViewName("login");
		registry.addViewController("/createReport").setViewName("createReport");
		registry.addViewController("/showReports").setViewName("showReports");
	}

}