package com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.service;

import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.controller.form.TestBusinessAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.entity.TestBusinessAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.repository.TestBusinessAccountRepository;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.controller.form.TestGeneralAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.repository.TestGeneralAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestBusinessAccountServiceImpl implements TestBusinessAccountService {

    final private TestBusinessAccountRepository testBusinessAccountRepository;

    @Override
    public TestBusinessAccount register(TestBusinessAccountRequestForm businessAccountRequestForm) {
        final Optional<TestBusinessAccount> maybeBusinessAccount =
                testBusinessAccountRepository.findByEmail(businessAccountRequestForm.getEmail());

        if (maybeBusinessAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }
        return testBusinessAccountRepository.save(businessAccountRequestForm.toTestBusinessAccount());
    }
}
