package com.example.demo.lectureClass.testcode.account.service;

import com.example.demo.lectureClass.testcode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testcode.account.entity.TestAccount;
import com.example.demo.lectureClass.testcode.account.repository.TestAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {

    final private TestAccountRepository testAccountRepository;

    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {
        final Optional <TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testAccountRepository.save(requestForm.toTestAccount());
    }

}
