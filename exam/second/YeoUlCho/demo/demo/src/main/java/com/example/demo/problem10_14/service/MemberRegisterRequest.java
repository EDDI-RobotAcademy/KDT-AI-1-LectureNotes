package com.example.demo.problem10_14.service;

import com.example.demo.problem10_14.entity.Member;
import com.example.demo.problem10_14.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberRegisterRequest {
    final private String name ;
    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Integer businessNumber;
    public Member toMember(){
        return new Member(name, email, password,businessNumber);
    }

}
