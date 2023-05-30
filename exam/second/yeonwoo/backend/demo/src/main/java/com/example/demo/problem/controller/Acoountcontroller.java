package com.example.demo.problem.controller;

import com.example.demo.problem.form.AccountLoginRequestForm;
import com.example.demo.problem.form.AccountRegisterRequestForm;
import com.example.demo.problem.service.AccountService;
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
public class Acoountcontroller {

    final private AccountService accountService;

    @PostMapping("/register")
    public Boolean accountRegister (@RequestBody AccountRegisterRequestForm requestForm) {
        return accountService.register(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/login")
    public String accountLogin (@RequestBody AccountRegisterRequestForm requestForm) {
        return accountService.login(requestForm.toAccountLoginRequest());
    }
}
