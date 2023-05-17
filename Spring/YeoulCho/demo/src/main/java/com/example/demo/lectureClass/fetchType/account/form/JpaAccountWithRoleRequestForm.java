package com.example.demo.lectureClass.fetchType.account.form;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import com.example.demo.lectureClass.testCode.account.entity.AccountRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountWithRoleRequestForm {

    final private String email;
    final private String password;
    final private String role;

    public JpaAccount toJpaAccount() {
        return new JpaAccount(email, password);
    }

    public JpaAccountRole toJpaAccountRole(JpaAccount account) {
        return new JpaAccountRole(role, account);
    }
}
