package com.example.demo.lectureClass.manager.service;

import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountLoginResponseForm;
import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountRequestForm;
import com.example.demo.lectureClass.manager.entity.TestManager;
import com.example.demo.lectureClass.manager.repository.TestManagerAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestManagerAccountServiceImpl implements TestManagerAccountService{

    final private TestManagerAccountRepository testManagerAccountRepository;
    @Override
    public TestManager register(TestManagerAccountRequestForm accountRequestForm) {
        final Optional<TestManager> maybeManager =
                testManagerAccountRepository.findByManagerEmail(accountRequestForm.getManagerEmail());

        if (maybeManager.isPresent()) {
            log.debug("관리자가 존재합니다.");
            return null;
        }
        return testManagerAccountRepository.save(accountRequestForm.toTestManager());
    }

    @Override
    public TestManagerAccountLoginResponseForm login(TestManagerAccountRequestForm accountRequestForm) {
        final Optional<TestManager> maybeManager =
                testManagerAccountRepository.findByManagerEmail(accountRequestForm.getManagerEmail());

        if (maybeManager.isEmpty()) {
            log.debug("로그인 실패!");
            return new TestManagerAccountLoginResponseForm(null);
        }

        if (maybeManager.isPresent()) {
            log.debug("로그인 성공!");
            return new TestManagerAccountLoginResponseForm(UUID.randomUUID());
        }
        return new TestManagerAccountLoginResponseForm(null);
    }
}
