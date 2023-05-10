package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.account.entity.TestAccount;
import com.example.demo.lectureClass.account.repository.TestAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {

    final private TestAccountRepository testAccountRepository;
    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {

        return testAccountRepository.save(requestForm.toTestAccount());
    }
}
