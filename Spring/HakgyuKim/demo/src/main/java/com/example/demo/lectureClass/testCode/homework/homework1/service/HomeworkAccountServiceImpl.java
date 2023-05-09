package com.example.demo.lectureClass.testCode.homework.homework1.service;

import com.example.demo.lectureClass.testCode.homework.homework1.entity.HomeworkAccount;

public class HomeworkAccountServiceImpl implements HomeworkAccountService{

    final private HomeworkAccountRepository homeworkAccountRepository;

    @Override
    public HomeworkAccount register(HomeworkAccount homeworkAccount) {
        return homeworkAccountRepository.save(homeworkAccount);
    }
}
