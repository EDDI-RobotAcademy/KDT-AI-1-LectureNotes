package com.example.demo.lectureClass.testCode.account.service.admin;

import com.example.demo.lectureClass.testCode.account.controller.form.admin.TestAdminAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.admin.TestAdminAccount;
import com.example.demo.lectureClass.testCode.account.repository.admin.TestAdminAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAdminAccountServiceImpl implements TestAdminAccountService{

    final private TestAdminAccountRepository testAdminAccountRepository;
    @Override
    public TestAdminAccount register(TestAdminAccountRequestForm requestForm) {
        final Optional<TestAdminAccount> maybeAdminAccount =
                testAdminAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeAdminAccount.isPresent()) {
            log.debug("이미 등록된 관리자입니다!");
            return null;
        }

        return testAdminAccountRepository.save(requestForm.toTestAdminAccount());
    }
}
