package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountWithRoleRequestForm;

import java.util.List;

public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);

    List<JpaAccountResponseForm> accountListWithRole(String role);
}
