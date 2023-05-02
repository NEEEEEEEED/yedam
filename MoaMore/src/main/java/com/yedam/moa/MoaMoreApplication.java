package com.yedam.moa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@MapperScan(basePackages="com.yedam.moa.**.mapper")
@Controller
public class MoaMoreApplication {
	//비밀번호 보안
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MoaMoreApplication.class, args);
	}
	
	@GetMapping("/login")
	public String hello() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	
}
