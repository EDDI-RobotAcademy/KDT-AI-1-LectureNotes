package com.example.demo.exam.refactorAccount;

import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessLoginResponseForm;
import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessRegisterRequestForm;
import com.example.demo.exam.refactorAccount.entity.AccountBusiness;
import com.example.demo.exam.refactorAccount.service.AccountBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/business-test")
public class BusinessController {

    @Autowired
    private AccountBusinessService accountBusinessService;

    @PostMapping("/business")
    public void register (@RequestBody AccountBusinessRegisterRequestForm requestForm) {
        log.info("registerBusiness()");

        accountBusinessService.register(requestForm.toAccountBusinessRegisterRequest());
    }

    @PostMapping("/business-login")
    public AccountBusiness loginAccount (@RequestBody AccountBusinessRegisterRequestForm requestForm) {

        return accountBusinessService.login(requestForm.toAccountBusinessRegisterRequest())
    }
}
