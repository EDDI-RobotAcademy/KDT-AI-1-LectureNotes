package com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.service;

import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.controller.form.TestAdminAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.entity.TestAdminAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.controller.form.TestGeneralAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;

public interface TestAdminAccountService {
    TestAdminAccount register(TestAdminAccountRequestForm adminAccountRequestForm);

}
