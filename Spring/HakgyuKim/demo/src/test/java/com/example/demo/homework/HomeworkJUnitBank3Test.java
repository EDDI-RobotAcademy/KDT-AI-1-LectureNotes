package com.example.demo.homework;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccount;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRoleType;
import com.example.demo.lectureClass.homework.jUnitBank3.form.HomeworkJpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.homework.jUnitBank3.service.HomeworkJpaAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class HomeworkJUnitBank3Test {

    @Autowired
    private HomeworkJpaAccountService accountService;

    @Test
    @DisplayName("ENUM활용 일반 회원 가입")
    void 일반_회원_가입 () {
        final String email ="test1@test.com";
        final String password = "test";
        final HomeworkJpaAccountRoleType roleType = HomeworkJpaAccountRoleType.valueOf("BUSINESS");
        HomeworkJpaAccountWithRoleRequestForm requestForm = new HomeworkJpaAccountWithRoleRequestForm(email, password, roleType);
        HomeworkJpaAccount account = accountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }

}
