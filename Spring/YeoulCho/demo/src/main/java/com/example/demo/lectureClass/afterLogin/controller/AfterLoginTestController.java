package com.example.demo.lectureClass.afterLogin.controller;

import com.example.demo.lectureClass.account.service.AccountService;
import com.example.demo.lectureClass.afterLogin.form.AfterLoginRequestForm;
import com.example.demo.lectureClass.authentication.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/after-login")
public class AfterLoginTestController {

    final private AccountService accountService;
    final private RedisService redisService;

    @PostMapping("/test")
    public void afterLoginTest(@RequestBody AfterLoginRequestForm requestForm){
        log.info("requestForm() " + requestForm);

        Long accountId =redisService.getValueByKey(requestForm.getUserToken());
        log.info("accountId " + accountId);

        accountService.findAccountInfoById(accountId);

    }
}
