package com.yedam.moa.custom;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.yedam.moa.member.service.MemberService;
import com.yedam.moa.member.service.MemberVO;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private MemberService memberService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String pw = (String) authentication.getCredentials();
		FormWebAuthenticationDetails details = (FormWebAuthenticationDetails) authentication.getDetails();
		String checkForm = details.getUserKey();
		if ("user".equals(checkForm)) {
			MemberVO member = memberService.getMember(id);
			if (member != null && memberService.authenticate(id, pw)) {
				Collection<? extends GrantedAuthority> authorities = member.getAuthorities();
				Authentication auth = new UsernamePasswordAuthenticationToken(member, pw, authorities);
				return auth;
			} else {
				throw new BadCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} else if (checkForm.equals("co")) {
			MemberVO member = memberService.getCoMember(id);
			if (member != null && memberService.authenticateCo(id, pw)) {
				Collection<? extends GrantedAuthority> authorities = member.getAuthorities();
				Authentication auth = new UsernamePasswordAuthenticationToken(member, pw, authorities);
				return auth;
			} else {
				throw new BadCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} else {
			throw new InsufficientAuthenticationException("InsufficientAuthenticationException");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
