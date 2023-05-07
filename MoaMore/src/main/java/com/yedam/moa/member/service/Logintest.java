package com.yedam.moa.member.service;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter @Entity
public class Logintest {

    public Logintest() {}

    @Id
    @SequenceGenerator(name="seq_id", sequenceName="seq_id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id")
    private Long id;

    @Column(nullable = true)
    private String name;
    
    @Column(nullable = true)
    private String nickname;

    @Column(nullable = false)
    private String email;
	
    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private String age; // 연령대

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role authr;


    public Logintest update(String name) {
        if (name != null) {
        	this.name = name;
        }
        return this;
    }

    public String getRoleKey() {
        return this.authr.getKey();
    }


}