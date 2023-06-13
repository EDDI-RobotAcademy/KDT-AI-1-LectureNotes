package kr.eddi.demo;

import kr.eddi.demo.problem1319.Account.controller.form.AccountLoginResponseForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountRequestForm;
import kr.eddi.demo.problem1319.Account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Problem18Test {
    @Autowired
    private AccountService accountService;
    @Test
    @DisplayName("회원이 로그인 합니다.")
    void 회원_로그인() {
        final String email = "qqqq@qqqq.com";
        final String password = "qqqq";


        AccountRequestForm requestForm = new AccountRequestForm(email, password);
        AccountLoginResponseForm responseForm = accountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
        // 랜덤 값을 가져오기 때문에 널만 아니면 된다.
    }
}
