package com.example.demo.homework;

import com.example.demo.lectureClass.testCode.homework.homework1.entity.HomeworkAccount;
import com.example.demo.lectureClass.testCode.homework.homework1.service.HomeworkAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeworkTest1 {

    @Autowired
    private HomeworkAccountService homeworkAccountService;

    @Test
    @DisplayName("아이디와 비밀번호로 회원가입")
    void accountRegister () {
        final String expectedEmail = "test@test.com";
        final String expectedPassword = "test123";
        HomeworkAccount homeworkTestAccount = new HomeworkAccount(expectedEmail, expectedPassword);
        homeworkAccountService.register(homeworkTestAccount);

        if (homeworkTestAccount == null) {
            System.out.println("중복된 닉네임이 있습니다");
            return;
        }

        final String actualEmail = homeworkTestAccount.getEmail();
        final String actualPassword = homeworkTestAccount.getPassword();

        assertEquals(expectedEmail, actualEmail);
        assertEquals(expectedPassword, actualPassword);
    }
}
