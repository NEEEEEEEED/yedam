package com.yedam.moa;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfiguration implements WebMvcConfigurer{
	
	@Value("${site.upload}")
	String uploadPath;
	@Value("${site.pofol}")
	String uploadPofolPath;
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	
		  registry.addResourceHandler("/moamoreImg/**")
		  .addResourceLocations("file:///"+uploadPath+"/")    
		  // 접근 파일 캐싱 시간 
		  .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES));
		  
		  registry.addResourceHandler("/moamorePofol/**")
		  .addResourceLocations("file:///"+uploadPofolPath+"/")    
		  // 접근 파일 캐싱 시간 
		  .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES));
        
    }
	
}
