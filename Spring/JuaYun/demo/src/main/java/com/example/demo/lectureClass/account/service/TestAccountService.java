package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.account.entity.TestAccount;
import com.example.demo.lectureClass.order.controller.form.TestAccountResponseForm;

import java.util.List;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);

    TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm);

    List<TestAccountResponseForm> accountListWithRole(String role);
}
