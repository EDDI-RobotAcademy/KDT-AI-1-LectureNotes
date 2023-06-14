package com.example.demo.evaluation.problem10_14_17_20.service;

import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginResponseForm;
import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.service.request.BusinessAccountRegisterRequest;
import com.example.demo.evaluation.problem10_14_17_20.service.request.NormalAccountRegisterRequest;

public interface AccountService {
    Account normalRegister(NormalAccountRegisterRequest normalAccountRegisterRequest);

    Account businessRegister(BusinessAccountRegisterRequest accountRegisterRequest);

    AccountLoginResponseForm login(AccountLoginRequestForm accountLoginRequestForm);
}
