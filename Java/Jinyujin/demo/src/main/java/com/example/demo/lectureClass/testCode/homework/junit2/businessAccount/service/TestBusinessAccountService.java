package com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.service;

import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.controller.form.TestBusinessAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.entity.TestBusinessAccount;

public interface TestBusinessAccountService {
    TestBusinessAccount register(TestBusinessAccountRequestForm businessAccountRequestForm);

}
