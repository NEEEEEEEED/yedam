package com.yedam.moa.member.service;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter @Entity
public class Member {

    public Member() {}

    @Id
    @SequenceGenerator(name="seq_id", sequenceName="seq_id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id")
    private Long api;

    @Column(nullable = true)
    private String name;
    
    @Column(nullable = true)
    private String nickname;

    @Column(nullable = false)
    private String email;
	
    @Column(nullable = true)
    private String gen;

    @Column(nullable = true)
    private String age; // 연령대
    
    @Column(nullable = true)
    private String birth;
    
    @Column(nullable = true)
    private String clsf;
    
    @Column(nullable = true)
    private String joinDt ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role authr;


    public Member update(String email, String name, String nickname, String gen, String age, String birth) {
        if (email != null) {
        	this.email = email;
        }
        if (name != null) {
        	this.name = name;
        }
        if (nickname != null) {
        	this.nickname = nickname;
        }
        if (gen != null) {
        	this.gen = gen;
        }
        if (age != null) {
        	this.age = age;
        }
        if (birth != null) {
        	this.birth = birth;
        }
        
        
        return this;
    }

    public String getRoleKey() {
        return this.authr.getKey();
    }


}