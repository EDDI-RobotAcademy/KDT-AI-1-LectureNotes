package com.example.demo.problem10.controller;

import com.example.demo.problem10.controller.form.AccountLoginRequestForm;
import com.example.demo.problem10.controller.form.AccountLoginResponseForm;
import com.example.demo.problem10.controller.form.AccountRequestForm;
import com.example.demo.problem10.entity.Account;
import com.example.demo.problem10.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    final private AccountService accountService;

    @PostMapping("/register")
    public Account registAccount(@RequestBody AccountRequestForm requestForm){

        return accountService.register(requestForm);

    }

    @PostMapping("login")
    public AccountLoginResponseForm loginAccount(@RequestBody AccountLoginRequestForm requestForm){

        return accountService.login(requestForm);
    }
}
