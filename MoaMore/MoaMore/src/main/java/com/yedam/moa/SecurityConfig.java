package com.yedam.moa;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.yedam.moa.custom.WebAuthenticationDetailsSource;
import com.yedam.moa.member.service.Impl.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final MemberServiceImpl userService;

	@Bean
	public PasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.antMatchers("/reportForm", "/jobQnA", "/signUp", "/loginForm", "/", "/find/**", "/main", "/error",
						"/joinMoaMore", "/checkId", "/sms/**")
				.permitAll().antMatchers("/admin/**").hasAuthority("ROLE_ADMIN").anyRequest().authenticated().and()
				.formLogin().loginPage("/login").usernameParameter("userid")
				// 시큐리티 로그인 커스텀
				.authenticationDetailsSource(webAuthenticationDetailsSource).successHandler(successHandler())
				.permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll().and()
				.csrf().disable()
				// API로그인 진행
				.oauth2Login().loginPage("/login")
				.userInfoEndpoint().userService(userService);
		return http.build();
	}

	private AuthenticationSuccessHandler successHandler() {
		return (request, response, authentication) -> {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

			System.out.println("권한" + roles);
			if (roles.contains("ROLE_ADMIN")) {
				response.sendRedirect("/admin");
			} else if (roles.contains("ROLE_MEM")) {
				response.sendRedirect("/main");
			} else {
				response.sendRedirect("/main");
			}
		};
	}

	// static 아래에 있는것들은 다 넣어주면됨
	// 정적 컨텐츠들은 다 넣어주면됨
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/fonts/**", "/community/**", "/기업정보관리/**",
				"/admin/**", "/images/**", "/js/**", "/css/**", "/moamorePofol/**", "/moamoreImg/**", "/assets/**",
				"/vendors/**");
	}

	@Autowired
	private WebAuthenticationDetailsSource webAuthenticationDetailsSource;
}
