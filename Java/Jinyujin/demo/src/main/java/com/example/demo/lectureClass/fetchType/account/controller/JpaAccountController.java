package com.example.demo.lectureClass.fetchType.account.controller;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account-role")
public class JpaAccountController {

    final private JpaAccountService accountService;

    @PostMapping("/enum")
    public void accountRole(@RequestBody JpaAccountWithRoleRequestForm roleRequestForm) {

        log.info("accountRole()");

        accountService.registerWithRole(roleRequestForm);
    }
}
