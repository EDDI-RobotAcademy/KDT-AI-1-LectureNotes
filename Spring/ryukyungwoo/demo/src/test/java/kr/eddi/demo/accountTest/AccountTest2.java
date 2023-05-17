package kr.eddi.demo.accountTest;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm2;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount2;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository2;
import kr.eddi.demo.lectureClass.testCode.account.service.TestAccountService2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountTest2 {

    @Autowired
    private TestAccountService2 testAccountService2;
    @Autowired
    private TestAccountRepository2 testAccountRepository2;

    @Test
    @DisplayName("testaccount")
    void testAccountRegister () {
        final String eMail = "test@test.com";
        final String password = "test";

        TestAccountRequestForm2 requestForm2 = new TestAccountRequestForm2(eMail, password);

        TestAccount2 account2 = testAccountRepository2.save(requestForm2.toRequest());

        assertEquals(eMail, account2.getEMail());
        assertEquals(password, account2.getPassword());
    }

    @Test
    @DisplayName("test account refactoring")
    void testAccountRegisterRefactoring () {
        final String eMail = "test@test.com";
        final String password = "test";

        TestAccountRequestForm2 requestForm2 = new TestAccountRequestForm2(eMail, password);

        TestAccount2 testAccount2 = testAccountRepository2.save(testAccountService2.register(requestForm2));

        assertEquals(eMail, testAccount2.getEMail());
        assertEquals(password, testAccount2.getPassword());
    }
}
