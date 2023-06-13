package kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.controller;

import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.controller.form.AccountRegisterForm;
import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service.AuthAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth-account")
@RestController
public class AuthAccountController {
    final AuthAccountService accountService;
    @PostMapping("/sign-up")
    public Boolean signUp(@RequestBody AccountRegisterForm regiterForm) {
        log.info("signUp()" + regiterForm.getEmail());
        return accountService.singUp(regiterForm.toAccountRgisterRequest());
    }
}
