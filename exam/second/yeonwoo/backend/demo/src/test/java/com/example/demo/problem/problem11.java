package com.example.demo.problem;

import com.example.demo.problem.entity.RoleType;
import com.example.demo.problem.form.AccountRegisterRequestForm;
import com.example.demo.problem.service.AccountServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem.entity.RoleType.BUSINESS;
import static com.example.demo.problem.entity.RoleType.NORMAL;

@SpringBootTest
public class problem11 {

    @Autowired
    private AccountServiceImpl accountService;

    @Test
    @DisplayName("일반회원 가입")
    void 일반회원_가입하기 () {
        final String email = "test@test.com";
        final String password = "test";
        final RoleType role = NORMAL;

        AccountRegisterRequestForm requestForm =
                new AccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = accountService.register(
                requestForm.toAccountRegisterRequest());

        assert(isSuccess);
    }

    @Test
    @DisplayName("사업자 가입")
    void 사업자회원_가입하기 () {
        final String email = "test@gmail.com";
        final String password = "tttt";
        final RoleType role = BUSINESS;

        AccountRegisterRequestForm requestForm =
                new AccountRegisterRequestForm(email,password, role);

        Boolean isSuccess = accountService.register(
                requestForm.toAccountRegisterRequest());

        assert(isSuccess);

    }


}
