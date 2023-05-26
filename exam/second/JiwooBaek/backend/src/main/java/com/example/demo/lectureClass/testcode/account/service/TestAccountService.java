package com.example.demo.lectureClass.testcode.account.service;

import com.example.demo.lectureClass.testcode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testcode.account.entity.TestAccount;

public interface TestAccountService {

    TestAccount register(TestAccountRequestForm requestForm);
}
