package com.example.demo.problem10.service;

import com.example.demo.problem10.controller.form.AccountLoginRequestForm;
import com.example.demo.problem10.controller.form.AccountLoginResponseForm;
import com.example.demo.problem10.controller.form.AccountRequestForm;
import com.example.demo.problem10.entity.Account;

public interface AccountService {
    Account register(AccountRequestForm requestForm);

    AccountLoginResponseForm login(AccountLoginRequestForm requestForm);
}
