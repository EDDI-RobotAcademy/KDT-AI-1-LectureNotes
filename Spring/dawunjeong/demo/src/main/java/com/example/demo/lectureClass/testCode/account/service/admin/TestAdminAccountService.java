package com.example.demo.lectureClass.testCode.account.service.admin;

import com.example.demo.lectureClass.testCode.account.controller.form.admin.TestAdminAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.admin.TestAdminAccount;

public interface TestAdminAccountService {
    TestAdminAccount register(TestAdminAccountRequestForm requestForm);
}
