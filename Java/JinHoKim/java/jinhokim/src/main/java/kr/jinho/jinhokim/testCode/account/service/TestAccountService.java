package kr.jinho.jinhokim.testCode.account.service;

import kr.jinho.jinhokim.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.jinho.jinhokim.testCode.account.controller.form.TestAccountRequestForm;
import kr.jinho.jinhokim.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import kr.jinho.jinhokim.testCode.account.entity.TestAccount;
import kr.jinho.jinhokim.testCode.order.controller.form.TestAccountResponseForm;

import java.util.List;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);


    TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm);

    List<TestAccountResponseForm> accountListWithRole(String role);
}
