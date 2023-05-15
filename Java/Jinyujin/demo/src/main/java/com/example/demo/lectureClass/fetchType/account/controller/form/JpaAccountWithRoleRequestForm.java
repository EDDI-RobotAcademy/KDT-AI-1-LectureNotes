package com.example.demo.lectureClass.fetchType.account.controller.form;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import com.example.demo.lectureClass.fetchType.account.entity.Role;
import com.example.demo.lectureClass.fetchType.account.entity.RoleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountWithRoleRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public JpaAccount toJpaAccount() {
        return new JpaAccount(email, password);
    }

//    public JpaAccountRole toJpaAccountRole(JpaAccount account) {
//        return new JpaAccountRole(role, account);
//    }

}
