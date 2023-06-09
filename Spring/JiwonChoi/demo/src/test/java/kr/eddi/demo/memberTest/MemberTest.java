package kr.eddi.demo.memberTest;


import kr.eddi.demo.memberCode.member.entity.TestMember;
import kr.eddi.demo.memberCode.member.service.TestMemberService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private TestMemberService testMemberService;

    @Test
    @DisplayName("x회원이 id:abc password:123로 회원등록하기")
    void memberRegister () {
        final String inputId = "abc";
        final String inputName = "x";
        final String inputPw = "123";

        TestMember testMember = new TestMember(inputId, inputName, inputPw);
        testMember = testMemberService.register(inputId, testMember.getName(), inputPw);

        if(testMember == null) {
            System.out.println("회원등록이 되지 않았습니다.");
        }
        System.out.println("회원등록 되었습니다.");
    }

}
