package com.example.demo.problem27.form;

import com.example.demo.problem10.entity.MemberRole;
import com.example.demo.problem10.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRequestForm {

    final private RoleType roleType;
    final private Long productId;
}
