package com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.service;

import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.controller.form.TestGeneralAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;

public interface TestGeneralAccountService {
    TestGeneralAccount register(TestGeneralAccountRequestForm generalAccountRequestForm);
}
