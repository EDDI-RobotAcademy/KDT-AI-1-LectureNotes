package kr.jinho.jinhokim.testCode.account.controller.form;

import kr.jinho.jinhokim.testCode.account.entity.TestAccount;
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
