package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;

import java.util.List;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);

    TestAccountLoginResponseForm login(TestAccountRequestForm requestForm);

    TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm);

    List<TestAccountResponseForm> accountListWithRole(String role);
}
