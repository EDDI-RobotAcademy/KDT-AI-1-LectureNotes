package kr.eddi.demo.testCode.account.service;

import kr.eddi.demo.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.testCode.account.entity.TestAccount;

public interface TestAccountService {

    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);
}