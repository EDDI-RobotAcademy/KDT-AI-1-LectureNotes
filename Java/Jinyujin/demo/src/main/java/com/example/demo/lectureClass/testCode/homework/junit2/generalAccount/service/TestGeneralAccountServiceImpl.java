package com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.service;

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
public class TestGeneralAccountServiceImpl implements TestGeneralAccountService{

    final private TestGeneralAccountRepository testGeneralAccountRepository;

    @Override
    public TestGeneralAccount register(TestGeneralAccountRequestForm generalAccountRequestForm) {
        final Optional<TestGeneralAccount> maybeGeneralAccount =
                testGeneralAccountRepository.findByEmail(generalAccountRequestForm.getEmail());

        if (maybeGeneralAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }
        return testGeneralAccountRepository.save(generalAccountRequestForm.toTestGeneralAccount());
    }
}
