package com.yedam.moa.member.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

	ROLE_ADMIN("ROLE_ADMIN", "관리자"),
	ROLE_CO("ROLE_CO", "기업회원"),
    ROLE_MEM("ROLE_MEM", "일반회원");

    private final String key;
    private final String value;
}