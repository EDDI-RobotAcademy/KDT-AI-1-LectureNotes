package com.example.demo.lectureClass.testCode.homework.homework1.service;

import com.example.demo.lectureClass.testCode.homework.homework1.entity.HomeworkAccount;
import com.example.demo.lectureClass.testCode.homework.homework1.repository.HomeworkAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeworkAccountServiceImpl implements HomeworkAccountService{

    final private HomeworkAccountRepository homeworkAccountRepository;

    @Override
    public HomeworkAccount register(HomeworkAccount homeworkAccount) {
        final Optional<HomeworkAccount> maybeAccount = homeworkAccountRepository.findByEmail(homeworkAccount.getEmail());

        if (maybeAccount.isPresent()) {
           log.info("중복된 이메일입니다.");
           return null;
        }

        return homeworkAccountRepository.save(homeworkAccount);
    }
}
