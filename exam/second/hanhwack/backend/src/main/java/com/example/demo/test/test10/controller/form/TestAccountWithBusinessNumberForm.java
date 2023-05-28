package com.example.demo.test.test10.controller.form;

import com.example.demo.test.test10.entity.AccountWithBusinessNumber;
import com.example.demo.test.test10.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountWithBusinessNumberForm {

    final private String email;
    final private String password;
    final private String role;
    final private Integer businessNumber;

    public TestAccount toTestAccount() {
        return new TestAccount(email, password, role);
    }

    public AccountWithBusinessNumber toTestAccountWithBusinessNumber(TestAccount account) {
        return new AccountWithBusinessNumber(businessNumber, account);
    }
}
