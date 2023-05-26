package com.example.demo.lectureClass.refactorAccount.service;

import com.example.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;

public interface RefactorAccountService {
    Boolean register(RefactorAccountRegisterRequest request);
}
