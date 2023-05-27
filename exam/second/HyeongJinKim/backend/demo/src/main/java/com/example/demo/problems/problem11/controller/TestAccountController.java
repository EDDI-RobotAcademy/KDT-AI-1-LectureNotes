package com.example.demo.problems.problem11.controller;

import com.example.demo.problems.problem11.controller.form.RequestAccountForm;
import com.example.demo.problems.problem11.controller.form.TestAccountRequestForm;
import com.example.demo.problems.problem11.controller.form.TestSigninRequestForm;
import com.example.demo.problems.problem11.controller.form.TestUserTokenResponseForm;
import com.example.demo.problems.problem11.service.TestAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class TestAccountController {

    @Autowired
    TestAccountService testAccountService;

    @PostMapping("/sign-up")
    public void accountSignUp (@RequestBody RequestAccountForm requestAccountForm) {

        TestAccountRequestForm accountRequestForm =
                new TestAccountRequestForm(
                        requestAccountForm.getEmail(),
                        requestAccountForm.getPassword(),
                        requestAccountForm.getRole(),
                        requestAccountForm.getBusinessNumber());

        testAccountService.register(accountRequestForm);

        // return testAccountService.register(accountRequestForm);
        // postman 테스트용
    }

    @PostMapping("/sign-in")
    public TestUserTokenResponseForm accountSignin (@RequestBody RequestAccountForm requestAccountForm) {

        TestSigninRequestForm signinRequestForm =
                new TestSigninRequestForm(
                        requestAccountForm.getEmail(),
                        requestAccountForm.getPassword());

        return testAccountService.signin(signinRequestForm);
    }
}
