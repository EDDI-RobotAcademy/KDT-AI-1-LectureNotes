package com.example.demo.managerTest;

import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountLoginResponseForm;
import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountRequestForm;
import com.example.demo.lectureClass.manager.entity.TestManager;
import com.example.demo.lectureClass.manager.service.TestManagerAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ManagerTest {

    @Autowired
    private TestManagerAccountService testManagerAccountService;
    @Test
    @DisplayName("관리자 회원가입")
    void 관리자가_회원_가입한다 () {
        final String managerEmail = "manager@manager.com";
        final String managerPassword = "manager";

        TestManagerAccountRequestForm accountRequestForm =
                new TestManagerAccountRequestForm(managerEmail, managerPassword);
        TestManager manager = testManagerAccountService.register(accountRequestForm);

        assertEquals(managerEmail, manager.getManagerEmail());
        assertEquals(managerPassword, manager.getManagerPassword());
    }

    @Test
    @DisplayName("관리자 로그인")
    void 관리자_로그인 () {
        final String managerEmail = "manager@manager.com";
        final String managerPassword = "manager";

        TestManagerAccountRequestForm accountRequestForm =
                new TestManagerAccountRequestForm(managerEmail, managerPassword);
        TestManagerAccountLoginResponseForm accountLoginResponseForm =
                testManagerAccountService.login(accountRequestForm);

        assertTrue(accountLoginResponseForm.getUserToken() != null);
    }
}
