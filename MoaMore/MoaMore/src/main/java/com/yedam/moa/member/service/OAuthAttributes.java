package com.yedam.moa.member.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OAuthAttributes {
	private final Map<String, Object> attributes;
	private final String nameAttributeKey;
	private final String nickname;
	private final String name;
	private final String email;
	private final String gen;
	private final String age;
	private final String birth;
	private final String clsf = "I1";
	private final String joinDt = joinDate();

	// 현재 날짜
	public static String joinDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
			Map<String, Object> attributes) {
		if ("naver".equals(registrationId)) {
			return ofNaver("id", attributes);
		}
		return ofKakao("id", attributes);

	}

	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
		@SuppressWarnings("unchecked")
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		String gender = (String) response.get("gender");
		if (gender == "M") {
			gender = "U1";
		} else if (gender == "F") {
			gender = "U2";
		} else {
			gender = "U3";
		}
		return OAuthAttributes.builder().name((String) response.get("name")).nickname((String) response.get("nickname"))
				.email((String) response.get("email")).gen(gender).age((String) response.get("age"))
				.birth((String) response.get("birthday")).attributes(response).nameAttributeKey(userNameAttributeName)
				.build();
	}

	private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
		Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
		String email = (String) kakaoAccount.get("email");
		String nickname = (String) profile.get("profile_nickname");
		String gender = (String) profile.get("gender");
		String age_range = (String) profile.get("age_range");
		String birthday = (String) profile.get("birthday");

		// OAuthAttributes 객체 생성
		return OAuthAttributes.builder().nickname(nickname).email(email).gen(gender).age(age_range).birth(birthday)
				.attributes(attributes).nameAttributeKey(userNameAttributeName).build();
	}

	public Member toEntity() {
		return Member.builder().name(name).nickname(nickname).email(email).gen(gen).age(age).clsf(clsf).joinDt(joinDt)
				.authr(Role.ROLE_MEM).build();
	}

}
