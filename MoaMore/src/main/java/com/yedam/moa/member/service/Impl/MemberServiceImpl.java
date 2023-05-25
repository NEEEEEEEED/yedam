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

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.custom.RegisterMail;
import com.yedam.moa.mem.MemVO;
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

    //private final HttpSession httpSession;
	
	@Autowired
	RegisterMail registerMail;

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
        //httpSession.setAttribute("user", new SessionUser(Member));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(Member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
	}

    private Member saveOrUpdate(OAuthAttributes attributes) {
        Member Member = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getEmail(), attributes.getName(), attributes.getBirth(), attributes.getGen(),attributes.getAge() , attributes.getNickname()))
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
	public int updateMember(MemVO vo) {
		return memberMapper.updateMember(vo);
	}


	@Override
	public String findId(MemVO vo) {
		return memberMapper.findId(vo);
	}


	@Override
	public String findpw(MemVO vo) throws Exception {
		int result = memberMapper.findPw(vo);
		System.out.println("result:"+result);
		if(result > 0) {
			String email = vo.getEmail();
	    	String code = registerMail.sendSimpleMessage(email);
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			String password = bcrypt.encode(code);
			vo.setPw(password);
			if(memberMapper.updateMember(vo)>0) {
				return "updateSuccess";
			} else {
				return "updateFail";
			}
		} else {
			return "noUser";
		}
		
	}

	@Override
	public String findCoId(CoVO vo) {
		return memberMapper.findCoId(vo);
	}

	@Override
	public String findCoPw(CoVO vo) throws Exception {
		MemVO mvo = memberMapper.findCoPw(vo);
		if(mvo.getId() != null && !mvo.getId().isEmpty() ) {
			System.out.println(mvo.getId());
			String email = vo.getEmail();
	    	String code = registerMail.sendSimpleMessage(email);
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			String password = bcrypt.encode(code);
			vo.setPw(password);
			if(memberMapper.updateMember(mvo)>0) {
				return "updateSuccess";
			} else {
				return "updateFail";
			}
		} else {
			return "noCoUser";
		}
		
	}




}
