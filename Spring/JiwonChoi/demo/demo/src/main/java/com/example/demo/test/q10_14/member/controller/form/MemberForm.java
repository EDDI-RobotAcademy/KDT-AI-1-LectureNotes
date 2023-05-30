package com.example.demo.test.q10_14.member.controller.form;

import com.example.demo.test.q10_14.member.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberForm {
    final private String email;
    final private String password;

    public Member toMember(){
        return new Member(email, password);
    }

}
