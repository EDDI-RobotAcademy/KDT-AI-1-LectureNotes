package com.example.demo.problem27.form;

import com.example.demo.problem10.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRoleResponseForm {

    final private RoleType roleType;
}
