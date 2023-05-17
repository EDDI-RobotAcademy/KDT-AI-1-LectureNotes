package com.example.demo.homework.junit2;

import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.controller.form.TestBusinessAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.entity.TestBusinessAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.service.TestBusinessAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BusinessMemberTest {

    @Autowired
    private TestBusinessAccountService testBusinessAccountService;

    @Test
    @DisplayName("사업자 회원 가입 할 수 있음")
        // yaml: create
    void 사업자_회원이_가입한다() {
        final String email = "test@test.com";
        final String password = "test";

        TestBusinessAccountRequestForm businessAccountRequestForm = new TestBusinessAccountRequestForm(email, password);
        TestBusinessAccount businessAccount = testBusinessAccountService.register(businessAccountRequestForm);

        assertEquals(email, businessAccount.getEmail());
        assertEquals(password, businessAccount.getPassword());
    }
}
