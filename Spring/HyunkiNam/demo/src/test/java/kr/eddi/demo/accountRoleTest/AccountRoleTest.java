package kr.eddi.demo.accountRoleTest;

import kr.eddi.demo.homework.account.entity.HomeworkAccount;
import kr.eddi.demo.homework.account.entity.HomeworkAccountRoleType;
import kr.eddi.demo.homework.account.controller.form.HomeworkAccountWithRoleRequestForm;
import kr.eddi.demo.homework.account.service.HomeworkAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static kr.eddi.demo.homework.account.entity.HomeworkAccountRoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountRoleTest {

    @Autowired
    private HomeworkAccountService accountService;

    @Test
    @DisplayName("FetchType = LAZY, 일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "normal@test.com";
        final String password = "test";
        final HomeworkAccountRoleType roleType = NORMAL;

        HomeworkAccountWithRoleRequestForm requestForm = new HomeworkAccountWithRoleRequestForm(email, password, roleType);
        HomeworkAccount account = accountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }
}