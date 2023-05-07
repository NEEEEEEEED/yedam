package com.yedam.moa.member.service;

import java.io.Serializable;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class SessionUser implements Serializable {
    SessionUser() {}

    public SessionUser(Logintest Logintest) {
        this.name = Logintest.getName();
        this.email = Logintest.getEmail();
        this.nickName = Logintest.getNickname();
    }

    private String nickName;
    
    private String name;

    private String email;

    
    private String gender;
    
    private String age;
}
