package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);
}