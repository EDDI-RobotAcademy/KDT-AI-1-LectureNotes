package com.example.demo.lectureClass.testCode.account.Service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;

import java.util.List;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);

//    TestAccount whatIsYourAccount(TestAccountRoleRequestForm accountRoleRequestForm, AccountRoleHomework accountRoleHomework);

    TestAccount registerWithRole(TestAccountWithRoleRequestForm roleRequestForm);

    List<TestAccountResponseForm> accountListWithRole(String role);
}
