package com.example.demo.exam.exam10To30.account.service;

import com.example.demo.exam.exam10To30.account.service.request.AccountRegisterRequest;
import com.example.demo.exam.exam10To30.account.form.LoginRequestForm;
import com.example.demo.exam.exam10To30.account.form.LoginResponseForm;

public interface AccountService {
    Boolean register(AccountRegisterRequest accountRegisterRequest);

    LoginResponseForm login(LoginRequestForm requestForm);

    Boolean checkRole(LoginResponseForm responseForm);
}
