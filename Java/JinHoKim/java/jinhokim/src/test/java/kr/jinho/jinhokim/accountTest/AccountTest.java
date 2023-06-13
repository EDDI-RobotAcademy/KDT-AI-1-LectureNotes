package kr.jinho.jinhokim.accountTest;

import kr.jinho.jinhokim.testCode.account.controller.form.AccountRoleRequestForm;
import kr.jinho.jinhokim.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.jinho.jinhokim.testCode.account.controller.form.TestAccountRequestForm;
import kr.jinho.jinhokim.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import kr.jinho.jinhokim.testCode.account.entity.TestAccount;
import kr.jinho.jinhokim.testCode.account.repository.TestAccountRepository;
import kr.jinho.jinhokim.testCode.account.service.TestAccountService;
import kr.jinho.jinhokim.testCode.order.controller.form.TestAccountResponseForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountRepository.save(requestForm.toTestAccount());

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다_refactoring() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("똑같은 사용자는 회원 가입 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null);
    }


    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 이메일만_맞게_입력한_상태에서_로그인() {
        final String email = "test@test.com";
        final String password = "응 틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("이메일을 잘못 입력한 상태로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인() {
        final String email = "gogo@gogo.com";
        final String password = "응 틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("올바르게 입력한 정보를 토대로 로그인")
    void 올바른_정보를_로그인() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
    }

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 일반회원_회원가입() {
        final String email = "gogo@gmail.com";
        final String password = "gogo";
        final String role = "NORMAL";

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 사업자_회원가입() {
        final String email = "business@test.com";
        final String password = "test";
        final String role = "BUSINESS";

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회() {
        final String role = "NORMAL";

        AccountRoleRequestForm requestForm = new AccountRoleRequestForm(role);
        List<TestAccountResponseForm> normalAccountList = testAccountService.accountListWithRole(role);

        for (TestAccountResponseForm responseForm : normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());

            assertTrue(responseForm.getAccountId() != null);
            assertTrue(responseForm.getEmail() != null);

        }
    }
}
