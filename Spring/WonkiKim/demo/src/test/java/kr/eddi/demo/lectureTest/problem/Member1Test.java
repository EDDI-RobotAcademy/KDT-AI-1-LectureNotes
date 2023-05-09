package kr.eddi.demo.lectureTest.problem;

import kr.eddi.demo.lectureClass.testCode.problem.entity.Member1;
import kr.eddi.demo.lectureClass.testCode.problem.service.Member1Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Member1Test {
    @Autowired
    private Member1Service memberService;
    @Test
    @DisplayName("signUp")
    void signUp() {
        final Member1 expected = new Member1("account3", "password1");
        final Member1 member = expected;

        final Member1 actual = memberService.register(member);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("deleteAccount")
    void deleteAccount() {
         final Member1 expected = new Member1("account3", "password1");
         final Member1 member = expected;
         final Member1 actual = memberService.delete(member);

         assertEquals(expected, actual);
    }

}
