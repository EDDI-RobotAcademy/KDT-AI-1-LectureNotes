package com.example.demo.memberTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class MemberTest {

    // 회원 등록
    @Test
    @DisplayName("x라는 이름 가진 회원 등록")
    void memberRegister() {
        final String expected = "x";
        TestMember testMember = new TestMember("x");
        testMember = testMemberService.register(testMember);

        if (testMember == null) {
            System.out.println("이름이 같아 생성하지 않습니다!");
            return;
        }

        final String actual = testMember.getName();

        assertEquals(expected, actual);
    }
}
