package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.service.request.AccountRegisterRequest;

public interface Accountservice {
    Boolean checkEmailDuplication(String email);
    Boolean signUp(AccountRegisterRequest request);
}
