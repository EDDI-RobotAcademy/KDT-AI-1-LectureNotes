package com.example.demo.FetchTypeTest;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountLazyFetchTypeTest {

    @Autowired
    private JpaAccountService jpaAccountService;

    @Test
    @DisplayName("FetchType = LAZY, 회원가입")
    void 일반_회원_가입(){
        final String email = "test2@test.com";
        final String password = "gogo";
        final String role = "BUSINESS";


        JpaAccountWithRoleRequestForm requestForm = new JpaAccountWithRoleRequestForm(email, password, role);
        JpaAccount account= jpaAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }
}
