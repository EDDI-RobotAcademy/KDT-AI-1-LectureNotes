package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountWithRoleRequestForm;

public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);
}
