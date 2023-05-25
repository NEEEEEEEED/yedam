package com.yedam.moa;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/user").setViewName("admin");
		registry.addViewController("/board").setViewName("admin");
		registry.addViewController("/approve").setViewName("admin");
		registry.addViewController("/pay").setViewName("admin");
	}
}

