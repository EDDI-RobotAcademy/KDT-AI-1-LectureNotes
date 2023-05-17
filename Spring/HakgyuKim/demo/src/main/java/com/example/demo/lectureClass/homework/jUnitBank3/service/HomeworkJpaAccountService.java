package com.example.demo.lectureClass.homework.jUnitBank3.service;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccount;
import com.example.demo.lectureClass.homework.jUnitBank3.form.HomeworkJpaAccountWithRoleRequestForm;

import java.util.List;

public interface HomeworkJpaAccountService {
    HomeworkJpaAccount registerWithRole(HomeworkJpaAccountWithRoleRequestForm requestForm);

}
