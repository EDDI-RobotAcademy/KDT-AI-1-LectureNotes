package com.example.demo.lectureClass.testCode.account.service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountCheckTypeRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountTypeResponseForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;

public interface TestAccountService {

    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);

    TestAccountTypeResponseForm findType(TestAccountCheckTypeRequestForm requestForm);
}
