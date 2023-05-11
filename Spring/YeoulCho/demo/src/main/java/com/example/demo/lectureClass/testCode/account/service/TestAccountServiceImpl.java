package com.example.demo.lectureClass.testCode.account.service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService{

    final private TestAccountRepository testAccountRepository;

    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount=
                testAccountRepository.findByEmail(requestForm.getEmail());
        if(maybeAccount.isPresent()){
            log.debug("이미 가입된 회원입니다!");
            log.info(maybeAccount.get().getEmail());
            log.info(requestForm.getEmail());
            return null;
        }
        return testAccountRepository.save(requestForm.toTestAccount());
    }
    @Override
    public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm){
        final Optional<TestAccount> maybeAccount =
              testAccountRepository.findByEmail(requestForm.getEmail());
        if(maybeAccount.isEmpty()){
            log.debug("로그인 실패");
            return new TestAccountLoginResponseForm(null);
        }
        TestAccount account = maybeAccount.get();
        if(account.getPassword().equals(requestForm.getPassword())){
            log.debug("로그인 성공");
             return new TestAccountLoginResponseForm(UUID.randomUUID());
        }
        return new TestAccountLoginResponseForm(null);
    }
}
