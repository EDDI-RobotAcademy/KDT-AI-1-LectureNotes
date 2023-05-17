package com.example.demo.lectureClass.homework.service;

import com.example.demo.lectureClass.homework.controller.form.HomeworkAccountRequestForm;
import com.example.demo.lectureClass.homework.entity.HomeworkAccount;

public interface HomeworkAccountService {
    HomeworkAccount register(HomeworkAccountRequestForm requestForm);
}
