package com.example.demo.problems.problem11.service;

import com.example.demo.problems.problem11.controller.form.TestAccountRequestForm;
import com.example.demo.problems.problem11.controller.form.TestSigninRequestForm;
import com.example.demo.problems.problem11.controller.form.TestUserTokenResponseForm;
import com.example.demo.problems.problem11.entity.TestAccount;
import com.example.demo.problems.problem11.repository.TestAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {

    final private TestAccountRepository testAccountRepository;

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
    public TestUserTokenResponseForm signin(TestSigninRequestForm signinRequestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail((signinRequestForm.getEmail()));
        if (maybeAccount.isEmpty()) {
            log.debug("로그인 실패");
            return new TestUserTokenResponseForm(null);
        }
        TestAccount account = maybeAccount.get();
        if (account.getPassword().equals(signinRequestForm.getPassword())) {
            log.debug("로그인 성공");
            return new TestUserTokenResponseForm(UUID.randomUUID());
        }
        return new TestUserTokenResponseForm(null);
    }
}
