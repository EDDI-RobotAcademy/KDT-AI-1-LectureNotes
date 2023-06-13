package com.example.demo.test.q10_14.member.service;

import com.example.demo.test.q10_14.member.controller.form.BusinessMemberForm;
import com.example.demo.test.q10_14.member.controller.form.MemberForm;
import com.example.demo.test.q10_14.member.entity.Member;

public interface MemberService {
    Member register(MemberForm memberForm);
    void businessRegister(BusinessMemberForm businessMemberForm);

    Member login(MemberForm memberForm);
}
