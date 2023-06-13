package com.example.demo.problem17;

import com.example.demo.problem10.controller.form.AccountWithRoleRequestForm;
import com.example.demo.problem10.service.AccountService;
import com.example.demo.problem17.controller.form.AccountLoginResponseForm;
import com.example.demo.problem17.controller.form.AccountRequestForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Problem17Test {

    /*
        백로그
        1. 등록된 일반 회원과 사업자 회원이 로그인하기 위한 인증을 진행합니다
           - 회원 데이터를 전달받아 로그인을 진행합니다
           - 요청된 데이터 중 email이 저장소에 저장되어 있는지 확인합니다
           - email이 저장되어 있다면 받은 password와 저장된 password가 일치하는지 확인합니다
           - password까지 일치한 사용자에게 userToken을 주어 인증합니다
     */

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("올바르게 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인() {

        final String email = "test@test.com";
        final String password = "test";

        AccountRequestForm requestForm = new AccountRequestForm(email, password);
        AccountLoginResponseForm responseForm = accountService.login(requestForm);
    }
}
