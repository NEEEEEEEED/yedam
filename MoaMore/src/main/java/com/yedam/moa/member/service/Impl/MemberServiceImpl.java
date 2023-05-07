package com.yedam.moa.member.service.Impl;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.yedam.moa.member.UserRepository;
import com.yedam.moa.member.mapper.MemberMapper;
import com.yedam.moa.member.service.Logintest;
import com.yedam.moa.member.service.MemberService;
import com.yedam.moa.member.service.MemberVO;
import com.yedam.moa.member.service.OAuthAttributes;
import com.yedam.moa.member.service.SessionUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements OAuth2UserService<OAuth2UserRequest, OAuth2User> , MemberService, UserDetailsService   {
	
    private final UserRepository userRepository;

    private final HttpSession httpSession;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();
		// naver, kakao 로그인 구분
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        Logintest Logintest = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(Logintest));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(Logintest.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
	}

    private Logintest saveOrUpdate(OAuthAttributes attributes) {
        Logintest Logintest = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName()))
                .orElse(attributes.toEntity());

        return userRepository.save(Logintest);
    }
    
	@Autowired
	MemberMapper memberMapper;
	
	// 단건조회
	@Override
	public MemberVO getMember(String id) {

		return memberMapper.getMember(id);
		
	}
	// 시큐리티 id 체크
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = memberMapper.getMember(username);
		if(memberVO == null) {
			throw new UsernameNotFoundException("no userid");
		}
		return memberVO;
	}

}
