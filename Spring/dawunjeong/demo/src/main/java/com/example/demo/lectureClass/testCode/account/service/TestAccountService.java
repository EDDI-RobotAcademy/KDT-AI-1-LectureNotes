package com.example.demo.lectureClass.testCode.account.service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;

public interface TestAccountService {

    TestAccount register(TestAccountRequestForm requestForm);
}
