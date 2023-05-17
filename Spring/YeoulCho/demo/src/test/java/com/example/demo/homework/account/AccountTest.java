package com.example.demo.homework.account;

import com.example.demo.lectureClass.homework.problem.testCode.Service.TestMemberService;
import com.example.demo.lectureClass.homework.problem.testCode.entity.TestMember;
import com.example.demo.lectureClass.homework.problem.testCode.form.MemberRequestForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountTest {
    @Autowired
    private TestMemberService testMemberService;

    @Test
    @DisplayName("회원정보 받아 회원가입하기")
    void TestSignUp(){
        final MemberRequestForm memberRequestForm =new MemberRequestForm("test1@test.com","cho1","as");
        TestMember expected = memberRequestForm.toTestMember();
        TestMember actual = testMemberService.register(expected);

        assertEquals(expected, actual);


    }

}
