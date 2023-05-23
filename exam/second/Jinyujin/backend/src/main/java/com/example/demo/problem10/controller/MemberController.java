package com.example.demo.problem10.controller;

import com.example.demo.problem10.controller.form.AccountWithRoleRequestForm;
import com.example.demo.problem10.controller.form.BusinessNumberRequestForm;
import com.example.demo.problem10.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem10")
public class MemberController {

    final private AccountService accountService;

    @PostMapping("/check")
    public void accountRole(@RequestBody AccountWithRoleRequestForm requestForm) {

        log.info("accountRole()");

        accountService.registerWithRole(requestForm);
    }
}
