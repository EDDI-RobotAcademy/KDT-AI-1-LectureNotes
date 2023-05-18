package com.example.demo.lectureClass.testCode.account.service.account;

import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.account.TestAccount;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;

import java.util.List;

public interface TestAccountService {

    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);

    TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm);

    List<TestAccountResponseForm> accountListWithRole(String role);
}
