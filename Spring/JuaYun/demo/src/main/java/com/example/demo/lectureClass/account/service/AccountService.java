package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.request.AccountRegisterRequest;


public interface AccountService {
    Boolean checkEmailDuplication(String email);

    Boolean signUp(AccountRegisterRequest request);
}