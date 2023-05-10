package com.example.demo.accountTest;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.account.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;
    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("사용자가 회원 가입을 할 수 있음")
    void 사용자가_회원_가입한다_refactoring () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }

    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 비밀번호를_틀리게_입력한_상태에서_로그인 () {
        final String email = "test@test.com";
        final String password = "응틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() == null);
    }

    @Test
    @DisplayName("이메일을 잘못 입력한 상태로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인 () {
        final String email = "gogo@gogo.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() == null);
    }
    @Test
    @DisplayName("올바른 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() != null);
    }
}
