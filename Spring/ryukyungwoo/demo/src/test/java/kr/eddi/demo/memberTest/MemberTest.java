package kr.eddi.demo.memberTest;

import kr.eddi.demo.lectureClass.testCode.member.entity.TestMember;
import kr.eddi.demo.lectureClass.testCode.member.service.TestMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class MemberTest {

    @Autowired
    TestMemberService testMemberService;

    @Test
    @DisplayName("회원 가입 하기")
    void registerMember () {
        TestMember testMember = testMemberService.register(new TestMember("x"));
    }
}
