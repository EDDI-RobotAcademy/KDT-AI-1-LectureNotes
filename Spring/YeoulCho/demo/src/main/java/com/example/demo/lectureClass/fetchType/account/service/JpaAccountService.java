package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountWithRoleRequestForm;

import java.util.List;

public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);
    List<JpaAccountResponseForm> accountListWithRole(String role);

}
