package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestTypeAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccountType;

public interface TestTypeAccountService {
    TestAccountType register(TestTypeAccountRequestForm requestForm);
}
