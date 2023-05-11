package com.example.demo.lectureClass.testCode.account.Service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRole;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);

    TestAccount whatIsYourAccount(TestAccountRequestForm requestForm, AccountRole accountRole);

}
