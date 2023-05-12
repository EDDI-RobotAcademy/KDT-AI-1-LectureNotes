package com.example.demo.fetchTypeTest;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountLazyFetchTypeTest {

    @Autowired
    private JpaAccountService accountService;

    @Test
    @DisplayName("FetchType = Lazy, 일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "normal@test.com";
        final String password = "test";
        final String role = "NORMAL";

        JpaAccountWithRoleRequestForm requestForm =
                new JpaAccountWithRoleRequestForm(email, password, role);
        JpaAccount account = accountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }
}
