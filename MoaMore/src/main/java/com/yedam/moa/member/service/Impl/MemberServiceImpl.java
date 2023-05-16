package com.yedam.moa.member.service.Impl;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.yedam.moa.member.UserRepository;
import com.yedam.moa.member.mapper.MemberMapper;
import com.yedam.moa.member.service.Member;
import com.yedam.moa.member.service.MemberService;
import com.yedam.moa.member.service.MemberVO;
import com.yedam.moa.member.service.OAuthAttributes;
import com.yedam.moa.member.service.SessionUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class MemberServiceImpl implements MemberService, OAuth2UserService<OAuth2UserRequest, OAuth2User> , UserDetailsService   {

	
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
        Member Member = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(Member));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(Member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
	}

    private Member saveOrUpdate(OAuthAttributes attributes) {
        Member Member = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getEmail(), attributes.getAge(), attributes.getBirth(), attributes.getGen(), attributes.getName(), attributes.getNickname()))
                .orElse(attributes.toEntity());

        return userRepository.save(Member);
    }
    
	@Autowired
	MemberMapper memberMapper;
	
	// 시큐리티 id 체크
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = memberMapper.getMember(username);
		if(memberVO == null) {
			throw new UsernameNotFoundException("no userid");
		} 
		return memberVO;
	}


	//로그인 성공 실패
	@Override
	public boolean authenticate(String id, String pw) {
		MemberVO member = memberMapper.getMember(id);
        if (member == null) {
            return false;
        }
        if (new BCryptPasswordEncoder().matches(pw, member.getPw())) {
            // 로그인 성공
            return true;
        } else {
            // 로그인 실패
            return false;
        }
	}
	
	@Override
	public boolean authenticateCo(String id, String pw) {
		MemberVO member = memberMapper.getCoMember(id);
        if (member == null) {
            return false;
        }
        if (new BCryptPasswordEncoder().matches(pw, member.getPw())) {
            // 로그인 성공
            return true;
        } else {
            // 로그인 실패
            return false;
        }
	}

	@Override
	public MemberVO getMember(String id) {
		
		return memberMapper.getMember(id);
	}
	
	 @Override
     public MemberVO getCoMember(String id) {
         return memberMapper.getCoMember(id);
     } 

	@Override
	public MemberVO getCoMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberVO vo) {
		return memberMapper.updateMember(vo);
	}



}
