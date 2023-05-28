package com.example.demo.problems.problem11.service;

import com.example.demo.problems.problem11.controller.form.TestAccountRequestForm;
import com.example.demo.problems.problem11.controller.form.TestSigninRequestForm;
import com.example.demo.problems.problem11.controller.form.TestUserTokenResponseForm;
import com.example.demo.problems.problem11.entity.TestAccount;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm accountRequestForm);

    TestUserTokenResponseForm signin(TestSigninRequestForm signinRequestForm);
}
