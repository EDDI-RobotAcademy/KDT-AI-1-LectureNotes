package com.example.demo.evaluation.problem10_14_17_20.controller;

import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginResponseForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.BusinessAccountRegisterRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.NormalAccountRegisterRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.service.AccountService;
import com.example.demo.evaluation.problem10_14_17_20.service.request.BusinessAccountRegisterRequest;
import com.example.demo.evaluation.problem10_14_17_20.service.request.NormalAccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 문제 13, 19번
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    final private AccountService accountService;

    // 문제 13번 - 1
    @PostMapping("/normal-register")
    public Account normalAccountRegister(@RequestBody NormalAccountRegisterRequestForm accountRegisterRequestForm) {
        NormalAccountRegisterRequest normalAccountRegisterRequest = new NormalAccountRegisterRequest(
                accountRegisterRequestForm.getEmail(),
                accountRegisterRequestForm.getPassword(),
                accountRegisterRequestForm.getRoleType()
        );
        log.info("accountRegister(): ");
        return accountService.normalRegister(normalAccountRegisterRequest);
    }

    // 문제 13번 - 2
    @PostMapping("/business-register")
    public Account businessAccountRegister(@RequestBody BusinessAccountRegisterRequestForm accountRegisterRequestForm) {
        BusinessAccountRegisterRequest normalAccountRegisterRequest = new BusinessAccountRegisterRequest(
                accountRegisterRequestForm.getEmail(),
                accountRegisterRequestForm.getPassword(),
                accountRegisterRequestForm.getRoleType(),
                accountRegisterRequestForm.getBusinessNumber()
        );
        log.info("accountRegister(): ");
        return accountService.businessRegister(normalAccountRegisterRequest);
    }

    // 문제 19번
    @PostMapping("/login")
    public AccountLoginResponseForm accountLogin(@RequestBody AccountLoginRequestForm accountLoginRequestForm) {
        AccountLoginResponseForm accountLoginResponseForm = accountService.login(accountLoginRequestForm);
        log.info("accountLogin(): ");
        return accountLoginResponseForm;
    }
}
