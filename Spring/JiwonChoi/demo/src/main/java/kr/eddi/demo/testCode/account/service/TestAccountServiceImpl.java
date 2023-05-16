package kr.eddi.demo.testCode.account.service;

import kr.eddi.demo.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.testCode.account.entity.TestAccount;
import kr.eddi.demo.testCode.account.repository.TestAccountRepository;
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
   public TestAccount register(TestAccountRequestForm requestForm){
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testAccountRepository.save(requestForm.toTestAccount());
    }

   @Override
   public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm){
     //동일한 이메일의 TestAccount를 찾음
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            log.info("로그인 실패");
            return new TestAccountLoginResponseForm(null);
        }

        TestAccount account = maybeAccount.get();

        if(account.getPassword().equals(requestForm.getPassword())){
            log.info("로그인 성공");
            return new TestAccountLoginResponseForm(UUID.randomUUID());
        }

        return new TestAccountLoginResponseForm(null); //비밀번호 불일치?
    }
}
