package com.example.springPart.account.controller;

import com.example.springPart.account.controller.form.LogInRequestForm;
import com.example.springPart.account.controller.form.SignUpRequestForm;
import com.example.springPart.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    final AccountService accountService;

    @PostMapping("/sign-up")
    public Long signUp(@RequestBody SignUpRequestForm signUpRequestForm) {
        log.info("signUp()");
        return accountService.signUp(signUpRequestForm).getId();
    }

    @PostMapping("/log-in")
    public Long logIn(@RequestBody LogInRequestForm requestForm) {
        log.info("logIn()");
        log.info(requestForm.getEmail());
        return accountService.logIn(requestForm).getId();
    }


}
