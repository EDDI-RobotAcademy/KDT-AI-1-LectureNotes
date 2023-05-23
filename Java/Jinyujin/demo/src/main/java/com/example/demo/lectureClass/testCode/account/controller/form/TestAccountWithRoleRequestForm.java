package com.example.demo.lectureClass.testCode.account.controller.form;

import com.example.demo.lectureClass.testCode.account.entity.AccountRole;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountWithRoleRequestForm {
    // 그냥 accountrequest에서 받기에는 의도가 명확하지 않아
    // 의사전달이 제대로 되지 않을 수 있어 새로 폼을 생성해줌

    final private String email;
    final private String password;
    final private String role;

    public TestAccount toTestAccount() {
        return new TestAccount(email, password);
    }

    public AccountRole toTestAccountRole(TestAccount account) {
        return new AccountRole(role, account);
    }
}
