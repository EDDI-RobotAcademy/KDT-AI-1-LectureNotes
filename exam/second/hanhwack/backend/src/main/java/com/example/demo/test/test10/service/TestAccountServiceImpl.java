package com.example.demo.test.test10.service;

import com.example.demo.test.test10.controller.form.TestAccountRequestForm;
import com.example.demo.test.test10.controller.form.TestAccountWithBusinessNumberForm;
import com.example.demo.test.test10.entity.TestAccount;
import com.example.demo.test.test10.repository.TestAccountRepository;
import com.example.demo.test.test10.repository.TestAccountWithBusinessNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {

    final private TestAccountRepository testAccountRepository;
    final private TestAccountWithBusinessNumberRepository testAccountWithBusinessNumberRepository;
    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {

        return testAccountRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestAccount registerWithBusinessNumber(TestAccountWithBusinessNumberForm requestForm) {


        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        testAccountWithBusinessNumberRepository.save(requestForm.toTestAccountWithBusinessNumber(account));

        return account;
    }
}