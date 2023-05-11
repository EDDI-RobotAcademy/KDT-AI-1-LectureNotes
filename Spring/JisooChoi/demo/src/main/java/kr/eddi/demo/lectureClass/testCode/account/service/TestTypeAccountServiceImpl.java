package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestTypeAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccountType;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestTypeAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestTypeAccountServiceImpl implements  TestTypeAccountService{

    final private TestTypeAccountRepository testTypeAccountRepository;

    @Override
    public TestAccountType register(TestTypeAccountRequestForm requestForm){
        final Optional<TestAccountType> maybeAccountType =
                testTypeAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccountType.isPresent()){
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testTypeAccountRepository.save(requestForm.toTestTypeAccount());
    }
}
