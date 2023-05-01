package com.yedam.moa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@MapperScan(basePackages="com.yedam.moa.**.mapper")
@Controller
public class MoaMoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoaMoreApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/")
	public String home() {
		return "MoaMore";
	}
	
	
}
