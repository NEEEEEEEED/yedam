package com.yedam.moa.member.service;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class OAuthAttributes {
    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String nickname;
    private final String name;
    private final String email;
    private final String gender;
    private final String age;

    
    public static OAuthAttributes of(String registrationId,String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }
        System.out.println("카카오 로그인 여기 까지 오니");
        return ofKakao("id", attributes);
        
    }

	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        @SuppressWarnings("unchecked")
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        System.out.println((String) response.get("name"));
        System.out.println((String) response.get("nickname"));
        System.out.println((String) response.get("age"));
        System.out.println((String) response.get("email"));
        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .nickname((String) response.get("nickname"))
                .email((String) response.get("email"))
                .gender((String) response.get("gender"))
                .age((String) response.get("age"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
	
	private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
		    Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
		    Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
		    String email = (String) kakaoAccount.get("email");
		    String name = (String) profile.get("name");

		    // OAuthAttributes 객체 생성
		    return OAuthAttributes.builder()
		            .name(name)
		            .email(email)
		            .attributes(attributes)
		            .nameAttributeKey(userNameAttributeName)
		            .build();
	}


	public Logintest toEntity() {
        return Logintest.builder()
        		.name(name)
                .nickname(nickname)
                .email(email)
                .gender(gender)
                .age(age)
                .authr(Role.ROLE_MEM)
                .build();
    }

}
