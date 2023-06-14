package kr.jinho.jinhokim.fetchTypeTest;

import kr.jinho.jinhokim.testCode.fetchType.account.controller.form.JpaAccountResponseForm;
import kr.jinho.jinhokim.testCode.fetchType.account.controller.form.JpaAccountRoleRequestForm;
import kr.jinho.jinhokim.testCode.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import kr.jinho.jinhokim.testCode.fetchType.account.entity.JpaAccount;
import kr.jinho.jinhokim.testCode.fetchType.account.service.JpaAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountLazyFetchTypeTest {

    @Autowired
    private JpaAccountService accountService;

    @Test
    @DisplayName("FetchType = LAZY, 일반 회원 가입")
    void 일반_회원_가입() {
        final String email = "normal@test.com";
        final String password = "test";
        final String role = "NORMAL";

        JpaAccountWithRoleRequestForm requestForm = new JpaAccountWithRoleRequestForm(email, password, role);
        JpaAccount account = accountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회() {
        final String role = "NORMAL";

        JpaAccountRoleRequestForm requestForm = new JpaAccountRoleRequestForm(role);
        List<JpaAccountResponseForm> normalAccountList = accountService.accountListWithRole(role);

        for (JpaAccountResponseForm responseForm : normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());

        }
    }
}
