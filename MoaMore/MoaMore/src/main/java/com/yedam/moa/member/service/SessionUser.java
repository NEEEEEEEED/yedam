package com.yedam.moa.member.service;

import java.io.Serializable;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class SessionUser implements Serializable {
    SessionUser() {}

    public SessionUser(Member Member) {
        this.name = Member.getName();
        this.email = Member.getEmail();
        this.nickName = Member.getNickname();
    }

    private String nickName;
    
    private String name;

    private String email;

    
    private String gender;
    
    private String age;
}
