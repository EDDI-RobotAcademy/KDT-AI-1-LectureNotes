package com.example.demo.test.q10_14.member.controller.form;

import com.example.demo.test.q10_14.member.entity.BusinessMember;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessMemberForm {
    final private String email;
    final private String password;
    final private String businessNumber;

    public BusinessMember toBusinessMember(){
        return new BusinessMember(email, password, businessNumber);
    }

}
