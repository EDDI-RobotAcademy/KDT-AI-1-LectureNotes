package com.example.demo.problem10_14.service;

import com.example.demo.problem10_14.controller.form.TestBusinessRequestForm;
import com.example.demo.problem10_14.controller.form.TestNormalRequestForm;
import com.example.demo.problem10_14.entity.TestBusinessMember;
import com.example.demo.problem10_14.entity.TestMember;

public interface TestMemberService {
    TestMember registerNormalMember(TestNormalRequestForm requestForm);

    TestBusinessMember registerBusinessMember(TestBusinessRequestForm requestForm);
}
