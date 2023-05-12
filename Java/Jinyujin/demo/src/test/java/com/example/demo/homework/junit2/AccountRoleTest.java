package com.example.demo.homework.junit2;

import com.example.demo.lectureClass.testCode.account.Service.TestAccountService;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.controller.form.TestAccountRoleRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRoleHomework;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.service.TestAccountRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountRoleTest {

    @Autowired
    private TestAccountRoleService accountRoleService;

    @Autowired
    private TestAccountService accountService;

//    @Test
//    @DisplayName("Account Role로 회원 타입 출력하기")
//    void Role로_회원_타입_출력() {
//
//        final String email = "test@test.com";
//        final String password = "test";
//
//        final String role = "일반 회원";
//
//        AccountRoleHomework accountRoleHomework = accountRoleService.whatIsYourType(role);
//        // 이 accountRole을 Account리포지토리에 있는 애들한테 넣어줘야 할 듯 싶은데
//
//        TestAccountRoleRequestForm accountRoleRequestForm = new TestAccountRoleRequestForm(email);
//        TestAccount account = accountService.whatIsYourAccount(accountRoleRequestForm, accountRoleHomework);
//
//        assertEquals(role, account.getAccountRole().getRole());
//    }
}
