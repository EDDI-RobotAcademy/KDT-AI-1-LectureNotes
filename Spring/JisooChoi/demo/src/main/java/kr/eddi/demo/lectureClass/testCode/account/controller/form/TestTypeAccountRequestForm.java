package kr.eddi.demo.lectureClass.testCode.account.controller.form;

import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccountType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestTypeAccountRequestForm {

    final private String email;
    final private String password;
    final private String type;

    public TestAccountType toTestTypeAccount() {
        return new TestAccountType(email, password, type);
    }

}
