package kr.eddi.demo.lectureTest.problem;

import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.LogInResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.problem.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberService memberService;
    @Test
    @DisplayName("회원가입테스트")
    void register() {
        String email = "test1@test.com";
        String password = "password";
        String memberRole = "normal";

        MemberRequestForm memberRequestForm = new MemberRequestForm(email, password, memberRole);
        Member member = memberService.register(memberRequestForm);

        assertEquals(email, member.getEmail());
        assertEquals(password, member.getPassword());
    }

    @Test
    @DisplayName("로그인 테스트")
    void 로그인_테스트() {
        String email = "test@test.com";
        String password = "password";
        String memberRole = "normal";

        MemberRequestForm memberRequestForm = new MemberRequestForm(email, password, memberRole);
        LogInResponseForm logInResponseForm = memberService.logIn(memberRequestForm.toMember());

        assertTrue(logInResponseForm.getUsertoken() != null);

    }
    @Test
    @DisplayName("틀린 계정명 로그인 테스트")
    void 틀린_계정명_로그인_테스트() {
        String email = "test1@test.com";
        String password = "password";
        String memberRole = "normal";

        MemberRequestForm memberRequestForm = new MemberRequestForm(email, password, memberRole);
        LogInResponseForm logInResponseForm = memberService.logIn(memberRequestForm.toMember());

        assertTrue(logInResponseForm.getUsertoken() == null);

    }
    @Test
    @DisplayName("틀린 비밀번호 로그인 테스트")
    void 틀린_비밀번호_로그인_테스트() {
        String email = "test@test.com";
        String password = "password1";
        String memberRole = "normal";

        MemberRequestForm memberRequestForm = new MemberRequestForm(email, password, memberRole);
        LogInResponseForm logInResponseForm = memberService.logIn(memberRequestForm.toMember());

        assertTrue(logInResponseForm.getUsertoken() == null);

    }
    @Test
    @DisplayName("일반회원만 조회하기")
    void 일반회원만_조회하기() {
        final String role = "normal";
        List<MemberResponseForm> normalMemberList = memberService.serchByRole(role);

        for(MemberResponseForm responseForm: normalMemberList) {
            System.out.println(responseForm.getEmail());
            System.out.println(responseForm.getId());
        }
    }
}
