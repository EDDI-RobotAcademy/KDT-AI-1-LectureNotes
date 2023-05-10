package com.example.demo.lectureClass.testCode.account.Service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService{

    final private TestAccountRepository testAccountRepository;

    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {
        return testAccountRepository.save(requestForm.toTestAccount());
    }
}
