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

import com.yedam.moa.member.service.Impl.MemberServiceImpl;
import com.yedam.moa.test.WebAuthenticationDetailsSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final MemberServiceImpl userService;

	// MemberServiceImpl에 있는것을 시큐리티가 가져다가 씀

	@Bean
	public PasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/loginForm", "/").permitAll().antMatchers("/admin/**")
				.hasAuthority("ROLE_ADMIN")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("userid")
				.authenticationDetailsSource(webAuthenticationDetailsSource)
				.successHandler(successHandler()) // successHandler()를 호출하여 로그인 성공 후 어떤 페이지로
																				// 이동할지 구현
				.permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll().and()
				.csrf().disable()
				.oauth2Login().loginPage("/loginForm").userInfoEndpoint().userService(userService);
		return http.build();
	}

	private AuthenticationSuccessHandler successHandler() {
		return (request, response, authentication) -> {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			
			//유저 정보 세션추가
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
		return (web) -> web.ignoring().antMatchers("/assets/**", "/admin/**", "/images/**", "/js/**", "/css/**",
				"/assets/**", "/vendors/**");
	}
	
    @Autowired
    private WebAuthenticationDetailsSource webAuthenticationDetailsSource;
}
