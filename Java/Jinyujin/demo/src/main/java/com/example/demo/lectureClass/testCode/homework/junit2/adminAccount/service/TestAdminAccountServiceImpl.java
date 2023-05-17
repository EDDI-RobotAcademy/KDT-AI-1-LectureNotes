package com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.service;

import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.controller.form.TestAdminAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.entity.TestAdminAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.repository.TestAdminAccountRepository;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.repository.TestGeneralAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestAdminAccountServiceImpl implements TestAdminAccountService{

    final private TestAdminAccountRepository testAdminAccountRepository;

    @Override
    public TestAdminAccount register(TestAdminAccountRequestForm adminAccountRequestForm) {
        final Optional<TestAdminAccount> maybeAdminAccount =
                testAdminAccountRepository.findByEmail(adminAccountRequestForm.getEmail());

        if (maybeAdminAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }
        return testAdminAccountRepository.save(adminAccountRequestForm.toTestAdminAccount());
    }
}
