package com.example.demo.exam.refactorAccount.service;


import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessLoginResponseForm;
import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessRegisterRequestForm;
import com.example.demo.exam.refactorAccount.entity.AccountBusiness;
import com.example.demo.exam.refactorAccount.form.AccountBusinessRegisterRequest;

public interface AccountBusinessService {
    AccountBusiness register(AccountBusinessRegisterRequest toAccountBusinessRegisterRequest);

    AccountBusinessLoginResponseForm login(AccountBusinessRegisterRequestForm requestForm);
}
