package com.example.demo.lectureClass.fetchType.account.controller.form;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import com.example.demo.lectureClass.fetchType.account.entity.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountRoleRequestForm {
    final private Role role;
}
