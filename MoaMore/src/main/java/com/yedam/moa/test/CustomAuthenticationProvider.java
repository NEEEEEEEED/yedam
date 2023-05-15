package com.yedam.moa.test;

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
        System.out.println(id);

        FormWebAuthenticationDetails details = (FormWebAuthenticationDetails)authentication.getDetails();
        String checkForm = details.getUserKey();
        System.out.println(checkForm);
        if("user".equals(checkForm)) {
            MemberVO member = memberService.getMember(id);
            System.out.println("user 여기오나");
            if (member != null && memberService.authenticate(id, pw)) {
                Collection<? extends GrantedAuthority> authorities = member.getAuthorities();
                Authentication auth = new UsernamePasswordAuthenticationToken(member, pw, authorities);
                return auth;
            } else {
                throw new BadCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        } else if(checkForm.equals("co")) {
            System.out.println("co 여기오나");
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
