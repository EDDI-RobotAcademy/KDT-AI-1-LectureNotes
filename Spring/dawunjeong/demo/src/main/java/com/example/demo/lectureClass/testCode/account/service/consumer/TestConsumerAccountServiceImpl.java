package com.example.demo.lectureClass.testCode.account.service.consumer;

import com.example.demo.lectureClass.testCode.account.controller.form.consumer.TestConsumerAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.consumer.TestConsumerAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.consumer.TestConsumerAccount;
import com.example.demo.lectureClass.testCode.account.repository.consumer.TestConsumerAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestConsumerAccountServiceImpl implements TestConsumerAccountService {

    final private TestConsumerAccountRepository testConsumerAccountRepository;
    @Override
    public TestConsumerAccount register(TestConsumerAccountRequestForm requestForm) {
        final Optional<TestConsumerAccount> maybeConsumerAccount =
                testConsumerAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeConsumerAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testConsumerAccountRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestConsumerAccountLoginResponseForm login(TestConsumerAccountRequestForm requestForm) {
        final Optional<TestConsumerAccount> maybeConsumerAccount
                = testConsumerAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeConsumerAccount.isEmpty()) {
            log.debug("로그인 실패!");
            return new TestConsumerAccountLoginResponseForm(null);
        }

        TestConsumerAccount account = maybeConsumerAccount.get();

        if(account.getPassword().equals(requestForm.getPassword())){
            log.debug("로그인 성공!");
            return new TestConsumerAccountLoginResponseForm(UUID.randomUUID());
        }

        return new TestConsumerAccountLoginResponseForm(null);
    }

}
