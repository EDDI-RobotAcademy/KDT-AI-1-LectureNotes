package com.example.demo.accountTest;

import com.example.demo.DemoApplication;
import com.example.demo.lectureClass.testcode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testcode.account.entity.TestAccount;
import com.example.demo.lectureClass.testcode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testcode.account.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountRepository.save(requestForm.toTestAccount());

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }


    }






