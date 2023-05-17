package com.example.demo.Problem10SignIn.controller;

import com.example.demo.Problem10SignIn.controller.form.AccountRequestForm;
import com.example.demo.Problem10SignIn.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/account-test")
public class AccountController {
    final private AccountService accountService;
    @GetMapping("/sign-in")
    public Boolean accountRegister(@RequestBody AccountRequestForm requestForm) {

        boolean isSuccess = accountService.register(requestForm.toAccountRequest());
        return isSuccess;
    }
}
