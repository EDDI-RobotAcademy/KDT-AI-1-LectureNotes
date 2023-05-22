package com.example.demo.exam.accountTest.controller;

import com.example.demo.exam.accountTest.controller.form.account.AccountLoginRequestForm;
import com.example.demo.exam.accountTest.controller.form.account.AccountRegisterRequestForm;
import com.example.demo.exam.accountTest.controller.form.business.BusinessLoginRequestForm;
import com.example.demo.exam.accountTest.controller.form.business.BusinessRegisterRequestForm;
import com.example.demo.exam.accountTest.service.account.AccountService;
import com.example.demo.exam.accountTest.service.business.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    final private AccountService accountService;
    final private BusinessService businessService;

    @PostMapping("/register") // 일반회원 가입
    public Boolean accountRegister (@RequestBody AccountRegisterRequestForm requestForm) {
        return accountService.register(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/login") // 일반회원 로그인
    public String accountLogin (@RequestBody AccountLoginRequestForm requestForm) {
        return accountService.login(requestForm.toAccountLoginRequest());
    }


    @PostMapping("/businessRegister") // 사업자 회원가입
    public Boolean businessRegister (@RequestBody BusinessRegisterRequestForm requestForm) {
        return businessService.register(requestForm.toBusinessRegisterRequest());
    }

    @PostMapping("/businessLogin")
    public String businessLogin (@RequestBody BusinessLoginRequestForm requestForm) {
        return businessService.login(requestForm.toBusinessLoginRequest());
    }
}
