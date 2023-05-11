package kr.eddi.demo.lectureClass.testCode.account.controller.form;

import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount2;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestAccountRequestForm2 {
    final private String eMail;
    final private String password;

    public TestAccount2 toRequest () {
        return new TestAccount2(eMail, password);
    }
}
