package com.example.demo.accountTest;

import com.example.demo.lectureClass.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.account.entity.TestAccount;
import com.example.demo.lectureClass.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.account.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("사용자가 회원가입 할 수 있음")
    void 사용자가_회원_가입한다_refactoring () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email,password);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 이메일만_맞게_입력한_상태에서_로그인 () {
        final String email = "test@test.com";
        final String password = "응틀렸어";
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("이메일을 잘못 입력한 상태로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인 () {
        final String email = "gogo@gogo.com";
        final String password = "응틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("올바른 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
    }

    @Test
    @DisplayName("똑같은 사용자는 회원 가입 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email,password);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null);

        // mysql 로 확인한 결과 오류의 원인은 같은 계정이 두개가 들어가있음
        // create 으로 변경하고 다시 회원가입
        // 다시 오류발생 이번엔 false 가 나와서
        // create 를 update 로 변경하여 돌리면 오류 해결

        // 로그인을 좀 더 관리하기 위해서 docker 기반의 redis 에 token 관리가 필요합니다.
        // token 관리는 Docker redis 및 ABS 설정 이후에 작업해야하므로 잠시 보류합니다.
    }

    // 로그아웃, 최원 탈퇴 같은 사항들이 남아있음
    // 이 사항들은 역시나 로그인 되어 있는 token 을 기반으로 진행되어야 합니다.
    // 그러므로 위 두 가지 사항은 현 시점에선 보류합니다.
}
