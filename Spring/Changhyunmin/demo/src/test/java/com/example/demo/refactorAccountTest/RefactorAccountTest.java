package com.example.demo.refactorAccountTest;

import kr.eddi.demo.DemoApplication;
import kr.eddi.demo.lectureClass.refactorAccount.controller.form.RefactorAccountRegisterRequestForm;
import kr.eddi.demo.lectureClass.refactorAccount.entity.RoleType;
import kr.eddi.demo.lectureClass.refactorAccount.service.RefactorAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static kr.eddi.demo.lectureClass.refactorAccount.entity.RoleType.BUSINESS;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class RefactorAccountTest {
    @Autowired
    private RefactorAccountService refactorAccountService;
    @Test
    @DisplayName("회원가입(회원 Role enum으로 리팩토링)")
    void 회원_가입_enum_타입_Role(){
        final String email = "test@test.com";
        final String password = "test";
        final RoleType role = BUSINESS;

        RefactorAccountRegisterRequestForm requestForm =
                new RefactorAccountRegisterRequestForm(email,password,role);
        Boolean isSuccess = refactorAccountService.register(
                requestForm.toRefactorAccountRegisterRequest());

        assertTrue(isSuccess);
    }
}
