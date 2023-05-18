package com.example.demo.homework.junit2;

import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.controller.form.TestGeneralAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.service.TestGeneralAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GeneralAccountTest {

    @Autowired
    private TestGeneralAccountService testGeneralAccountService;

    @Test
    @DisplayName("일반 회원 가입 할 수 있음")
    // yaml: create
    void 일반_회원이_가입한다() {
        final String email = "test@test.com";
        final String password = "test";

        TestGeneralAccountRequestForm generalAccountRequestForm = new TestGeneralAccountRequestForm(email, password);
        TestGeneralAccount generalAccount = testGeneralAccountService.register(generalAccountRequestForm);

        assertEquals(email, generalAccount.getEmail());
        assertEquals(password, generalAccount.getPassword());
    }
}