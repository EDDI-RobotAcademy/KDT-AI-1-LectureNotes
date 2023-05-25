package com.example.demo.problem.problem11.account.service;

import com.example.demo.problem.problem11.account.controller.form.TestAccountRequestForm;
import com.example.demo.problem.problem11.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.problem.problem11.account.entity.TestAccount;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);

    TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm);
}