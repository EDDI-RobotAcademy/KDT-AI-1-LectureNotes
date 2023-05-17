package com.example.demo.exam.refactorAccount.service;


import com.example.demo.exam.refactorAccount.controller.form.RefactorAccountRegisterRequestForm;
import com.example.demo.exam.refactorAccount.entity.RefactorAccount;
import com.example.demo.exam.refactorAccount.controller.form.RefactorAccountLoginResponseForm;
import com.example.demo.exam.refactorAccount.form.RefactorAccountRegisterRequest;

public interface RefactorAccountService {

    Boolean register(RefactorAccountRegisterRequest toRefactorAccountRegisterRequest);
    RefactorAccountLoginResponseForm login(RefactorAccountRegisterRequestForm requestForm);

}
