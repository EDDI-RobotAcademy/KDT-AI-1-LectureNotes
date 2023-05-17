package com.example.demo.homeworkTest;

import com.example.demo.lectureClass.homework.controller.form.HomeworkAccountRequestForm;
import com.example.demo.lectureClass.homework.entity.HomeworkAccount;
import com.example.demo.lectureClass.homework.entity.RoleType;
import com.example.demo.lectureClass.homework.service.HomeworkAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.lectureClass.homework.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeworkTest {
    @Autowired
    private HomeworkAccountService homeworkAccountService;

    @Test
    @DisplayName("ENUM 타입의 ROLE 적용하여 회원가입하기")
    void 사용자가_회원_가입한다 () {
        final String email = "testtest4@test.com";
        final String password = "test";
        final RoleType roleType = NORMAL;

        HomeworkAccountRequestForm requestForm = new HomeworkAccountRequestForm(email, password, roleType);
        HomeworkAccount homeworkAccount = homeworkAccountService.register(requestForm);

        assertEquals(email, homeworkAccount.getEmail());
        assertEquals(password, homeworkAccount.getPassword());

    }
}
