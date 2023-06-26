package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.entity.MemberAccount;
import com.example.demo.lectureClass.account.service.request.AccountRegisterRequest;
import com.example.demo.lectureClass.afterLogin.controller.form.AccountResponseForm;

public interface AccountService {
    Boolean checkEmailDuplication(String email);

    Boolean signUp(AccountRegisterRequest request);

    Long findAccountIdByEmail(String email);

    Long signUpWithEmail(String email);

    AccountResponseForm findAccountInfoById(Long accountId);
}
