package com.example.demo.problem.account.controller;

import com.example.demo.problem.account.controller.form.AccountLoginRequestForm;
import com.example.demo.problem.account.controller.form.AccountRegisterRequestForm;
import com.example.demo.problem.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    final private AccountService accountService;
    // 사용할 서비스 가져온다.

    @PostMapping("/register")
    public Boolean accountRegister (@RequestBody AccountRegisterRequestForm requestForm) {
        // 전달 받은 폼으로 매서드 진행후 참 거짓 리턴 한다.
        return accountService.register(requestForm.toAccountRegisterRequest());
        //서비스 결과 리턴한다.
        //
    }

    @PostMapping("/login")
    public String accountLogin (@RequestBody AccountLoginRequestForm requestForm) {
        return accountService.login(requestForm.toAccountLoginRequest());
    }
}
