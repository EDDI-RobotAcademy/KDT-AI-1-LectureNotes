package kr.eddi.demo.memberTest;

import kr.eddi.demo.lectureClass.testCode.member.entity.TestMember;
import kr.eddi.demo.lectureClass.testCode.member.service.TestMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberTest {

    @Autowired
    private TestMemberService memberService;

    @Test
    @DisplayName("x라는 이름 가진 회원 등록")
    void memberRegister() {
        final String expected = "ee";
        TestMember testMember = new TestMember("ee", "test@test.com","1234");
        testMember = memberService.register(testMember);

        if (testMember == null) {
            System.out.println("이름이 같아 생성하지 않습니다!");
            return;
        }

        final String actual = testMember.getName();

        assertEquals(expected, actual);
    }
}
