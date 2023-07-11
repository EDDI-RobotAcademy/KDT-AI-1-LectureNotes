package kr.eddi.demo.lectureClass.afterLogin.controller;

import kr.eddi.demo.lectureClass.account.controller.form.AccountResponseForm;
import kr.eddi.demo.lectureClass.account.service.AccountService;
import kr.eddi.demo.lectureClass.afterLogin.controller.form.AfterLoginRequestForm;
import kr.eddi.demo.lectureClass.authentication.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/after-login")
public class AfterLoginTestController {

    final private AccountService accountService;
    final private RedisService redisService;

    @PostMapping("/test")
    public AccountResponseForm afterLoginTest (@RequestBody AfterLoginRequestForm requestForm) {
        log.info("afterLoginTest(): " + requestForm);

        Long accountId = redisService.getValueByKey(requestForm.getUserToken());
        log.info("accountId: " + accountId);

        return accountService.findAccountInfoById(accountId);
    }
}