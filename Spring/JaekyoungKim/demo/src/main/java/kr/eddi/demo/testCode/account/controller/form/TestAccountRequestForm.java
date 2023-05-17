package kr.eddi.demo.testCode.account.controller.form;


import kr.eddi.demo.testCode.account.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountRequestForm {

    final private String email;
    final private String password;


    public TestAccount toTestAccount() {
        return new TestAccount(email, password);
    }
}
