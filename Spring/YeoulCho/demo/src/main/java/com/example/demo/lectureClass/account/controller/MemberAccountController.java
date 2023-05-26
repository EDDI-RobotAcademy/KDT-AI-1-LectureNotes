package com.example.demo.lectureClass.account.controller;

import com.example.demo.lectureClass.account.form.AccountRegisterForm;
import com.example.demo.lectureClass.account.service.Accountservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class MemberAccountController {
    final private Accountservice accountservice;
    @GetMapping("/check-email/{email}")
    public Boolean checkEmail(@PathVariable("email") String email){
        log.info("check email duplication: "+ email);

        return accountservice.checkEmailDuplication(email);
    }

    @PostMapping("sign-up")
    public Boolean signUp(@RequestBody AccountRegisterForm form){
        log.info("signUP(): "+ form);
        return accountservice.signUp(form.toAccountRegisterRequest());
    }
}
