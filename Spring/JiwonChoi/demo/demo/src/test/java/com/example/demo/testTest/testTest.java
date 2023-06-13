package com.example.demo.testTest;

import com.example.demo.test.q10_14.member.controller.form.BusinessMemberForm;
import com.example.demo.test.q10_14.member.controller.form.MemberForm;
import com.example.demo.test.q10_14.member.entity.Member;
import com.example.demo.test.q10_14.member.repository.MemberRepository;
import com.example.demo.test.q10_14.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class testTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("일반회원 회원가입")
    void 일반회원이_회원가입합니다(){
        String emaill = "test1@test.com";
        String password = "test1";
        MemberForm memberForm = new MemberForm(emaill, password);
        memberService.register(memberForm);
    }

    @Test
    @DisplayName("사업자회원 회원가입")
    void 사업자회원이_회원가입합니다(){
        String emaill = "Btest1@test.com";
        String password = "Btest1";
        String businessNumber = "1234567890";
        BusinessMemberForm businessMemberForm = new BusinessMemberForm(emaill, password, businessNumber);
        memberService.businessRegister(businessMemberForm);
    }

    @Test
    @DisplayName("일반회원 로그인")
    void 일반회원이_로그인합니다(){
        String emaill = "test1@test.com";
        String password = "test2";
        MemberForm memberForm = new MemberForm(emaill, password);
        memberService.login(memberForm);
    }
}

