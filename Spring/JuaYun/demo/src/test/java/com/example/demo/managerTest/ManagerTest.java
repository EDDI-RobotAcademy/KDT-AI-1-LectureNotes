package com.example.demo.managerTest;

import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountRequestForm;
import com.example.demo.lectureClass.manager.controller.form.TestManagerResponseForm;
import com.example.demo.lectureClass.manager.entity.TestManager;
import com.example.demo.lectureClass.manager.service.TestManagerAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ManagerTest {

    @Autowired
    private TestManagerAccountService testManagerAccountService;
    @Test
    @DisplayName("회원가입을 한다")
    void 회원가입_하기 () {
        final String email = "test@test.com";
        final String password = "test";
        final String role = "일반회원";

        TestManagerAccountRequestForm requestForm =
                new TestManagerAccountRequestForm(email, password, role);
        TestManager manager = testManagerAccountService.registerWithRole(requestForm);

        assertEquals(email, manager.getEmail());
        assertEquals(password, manager.getPassword());

    }

    @Test
    @DisplayName("회원 조회하기")
    void 회원_조회 () {
        final String role = "일반회원";

        List<TestManagerResponseForm> accountList = testManagerAccountService.accountListWithRole(role);
        // order 때문에 존재하는 Form 없다면 생성
        // accountId와 email 이 있음

        for (TestManagerResponseForm responseForm: accountList) {
            System.out.println("responseForm.getEmail: " + responseForm.getEmail());

            assertTrue(responseForm.getEmail() != null);
        }
    }

}
