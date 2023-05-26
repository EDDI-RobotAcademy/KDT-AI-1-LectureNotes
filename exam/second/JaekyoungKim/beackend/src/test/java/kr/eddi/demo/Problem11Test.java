package kr.eddi.demo;

import kr.eddi.demo.problem1319.Account.controller.form.AccountWithNormalRoleRequestForm;
import kr.eddi.demo.problem1319.Account.entity.Account;
import kr.eddi.demo.problem1319.Account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Problem11Test {
    @Autowired
    private AccountService accountService;
    @Test
    @DisplayName("일반 회원이 가입합니다.")
    void 일반_회원_가입(){
        final String email = "qqqq@qqqq.com";
        final String password = "qqqq";
        final String role = "NORMAL";

        AccountWithNormalRoleRequestForm requestForm = new AccountWithNormalRoleRequestForm(email, password, role);
        Account account = accountService.normalMemberRegister(requestForm);
        // 생성된 어카운트의 이메일과 패스워드가 내가 넣은 것과 같이 같은지 체크한다.
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }
}