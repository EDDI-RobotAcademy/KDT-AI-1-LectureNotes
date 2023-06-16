package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.controller.form.AccountResponseForm;
import com.example.demo.lectureClass.account.entity.MemberAccount;
import com.example.demo.lectureClass.account.service.request.AccountRegisterRequest;

public interface AccountService {
    Boolean checkEmailDuplication(String email);

    Boolean signUp(AccountRegisterRequest request);

    Long findAccountIdByEmail(String email);

    Long signUpWithEmail(String email);

    AccountResponseForm findAccountInfoById(Long accountId);
}