package com.example.demo.refactorAccountTest;

import com.example.demo.lectureClass.refactorAccount.form.RefactorAccountRegisterRequestForm;
import com.example.demo.lectureClass.refactorAccount.service.RefactorAccountService;
import com.example.demo.lectureClass.refactorAccount.entity.RoleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.lectureClass.refactorAccount.entity.RoleType.BUSINESS;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RefactorAccountTest {

    @Autowired
     private RefactorAccountService refactorAccountService;
    @Test
    @DisplayName("회원가입 회원 Role enum으로 리펙토링")
    void 회원_가입_enum_타입_Role () {
        final String email = "test@gmail.com";
        final String password = "test";
        final RoleType role = BUSINESS;

        RefactorAccountRegisterRequestForm requestForm =
                new RefactorAccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = refactorAccountService.register(
                requestForm.toRefactorAccountRegisterRequest());

        assertTrue(isSuccess);
    }
}
