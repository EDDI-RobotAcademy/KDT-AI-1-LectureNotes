package com.example.demo.membership;

import kr.eddi.demo.DemoApplication;
import kr.eddi.demo.lectureClass.testCode.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MembershipTest {
    @Autowired
    MemberService memberService;
    @Test
    @DisplayName("회원가입")
    void 회원가입_확인_메시지(){
        Member member = memberService.register(new Member());
    }

}
