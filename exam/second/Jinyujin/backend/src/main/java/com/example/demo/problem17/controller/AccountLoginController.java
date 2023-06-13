package com.example.demo.problem17.controller;

import com.example.demo.problem10.service.AccountService;
import com.example.demo.problem17.controller.form.AccountRequestForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem17")
public class AccountLoginController {

    final private AccountService accountService;

    @PostMapping("/check-login")
    public void checkLogin(@RequestBody AccountRequestForm requestForm) {

        log.info("checkLogin()");

        accountService.login(requestForm);
    }
}
