package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.account.entity.TestAccount;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);
}
