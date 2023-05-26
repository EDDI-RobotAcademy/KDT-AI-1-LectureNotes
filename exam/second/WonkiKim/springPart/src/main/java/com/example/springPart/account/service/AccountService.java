package com.example.springPart.account.service;

import com.example.springPart.account.controller.form.LogInRequestForm;
import com.example.springPart.account.controller.form.SignUpRequestForm;
import com.example.springPart.account.entity.Account;

public interface AccountService {
    Account signUp(SignUpRequestForm signUpRequestForm);

    Account logIn(LogInRequestForm requestForm);
}
