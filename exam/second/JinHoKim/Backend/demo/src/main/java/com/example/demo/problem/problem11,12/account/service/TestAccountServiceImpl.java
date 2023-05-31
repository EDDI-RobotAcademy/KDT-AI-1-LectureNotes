package com.example.demo.problem.problem11.account.service;

import com.example.demo.problem.problem11.account.controller.form.TestAccountRequestForm;
import com.example.demo.problem.problem11.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.problem.problem11.account.entity.TestAccount;
import com.example.demo.problem.problem11.account.repository.TestAccountRepository;
import com.example.demo.problem.problem11.account.repository.TestAccountRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements com.example.demo.problem.problem11.account.service.TestAccountService {

    final private TestAccountRepository testAccountRepository;
    final private TestAccountRoleRepository testAccountRoleRepository;

    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testAccountRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        testAccountRoleRepository.save(requestForm.toTestAccountRole(account));

        return account;
    }

}