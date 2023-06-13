package com.example.demo.Problem10SignIn.controller;

import com.example.demo.Problem10SignIn.controller.form.AccountLoginRequestForm;
import com.example.demo.Problem10SignIn.controller.form.AccountRequestForm;
import com.example.demo.Problem10SignIn.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/log-in")
    public String accountLogin(@RequestBody AccountLoginRequestForm requestForm) {

        String isLogin = accountService.login(requestForm.toAccountLoginRequest()).getUniqueRandomName();

        return isLogin;
    }
}
