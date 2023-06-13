package com.example.demo.test.q10_14.member.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
public class BusinessMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String password;
    private String businessNumber;

    public BusinessMember(String email, String password, String businessNumber) {
        this.email = email;
        this.password = password;
        this.businessNumber = businessNumber;
    }
}
