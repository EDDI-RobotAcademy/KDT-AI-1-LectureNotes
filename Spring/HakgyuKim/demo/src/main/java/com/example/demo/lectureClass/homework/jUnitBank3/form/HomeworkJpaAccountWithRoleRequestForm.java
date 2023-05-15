package com.example.demo.lectureClass.homework.jUnitBank3.form;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccount;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRole;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HomeworkJpaAccountWithRoleRequestForm {

    final private String email;
    final private String password;
    final private HomeworkJpaAccountRoleType roleType;

    public HomeworkJpaAccount toJpaAccount() {
        return new HomeworkJpaAccount(email, password);
    }

}
