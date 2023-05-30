package kr.eddi.demo.lectureClass.account.controller;

import jakarta.servlet.http.HttpServletResponse;
import kr.eddi.demo.lectureClass.account.controller.form.AccountRegisterForm;
import kr.eddi.demo.lectureClass.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class MemberAccountController {

    final private AccountService accountService;

    @GetMapping("/check-email/{email}")
    public Boolean checkEmail(@PathVariable("email") String email) {
        log.info("check email duplication: " + email);

        return accountService.checkEmailDuplication(email);
    }

    @PostMapping("/sign-up")
    public Boolean signUp(@RequestBody AccountRegisterForm form) {
        log.info("signUp(): " + form);

        return accountService.signUp(form.toAccountRegisterRequest());
    }

//    @GetMapping("/github/login")
//    public void githubLoginCallback(HttpServletResponse response) throws IOException {
//        response.sendRedirect("http://localhost:8080/");
//    }
}
