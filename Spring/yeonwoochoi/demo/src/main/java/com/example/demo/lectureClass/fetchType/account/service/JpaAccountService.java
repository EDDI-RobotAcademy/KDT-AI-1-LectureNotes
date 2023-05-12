package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;

public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);
}
