package com.example.demo.problem10_14.form;

import com.example.demo.problem10_14.entity.RoleType;
import com.example.demo.problem10_14.service.MemberRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class MemberRegisterRequestForm {
    final private String name ;
    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Integer businessNumber;

    public MemberRegisterRequest toMemberRegisterRequest() {
        return new MemberRegisterRequest(name, email, password, roleType, businessNumber);
    }
}
