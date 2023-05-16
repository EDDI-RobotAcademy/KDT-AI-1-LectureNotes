package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.service;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form.TestPracticeResponseForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.repository.TestPracticeAccountRepository;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form.TestPracticeAccountRequestForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity.TestPracticeAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestPracticeAccountServiceImpl implements TestPracticeAccountService {

    /*
        기능을 처리하는 서비스에서는
        DataBase 에 값을 조회하고, 저장하고, 삭제하는 등의 연산을 해야하므로
        전역 변수로 repository(= DB)를 선언하고 사용한다.
     */
    @Autowired
    private TestPracticeAccountRepository testPracticeAccountRepository;

    @Override
    public TestPracticeAccount register(TestPracticeAccountRequestForm requestForm){
        /*
            전달받은 Email 값의 존재여부 확인

            requestForm 의 email 값을 가지고
            repository(=DB) 에 동일한 email 값이 있다면
            Optional 해라 ! (= 가지고 와라, 값이 없다면 null 값을 가지고 있다.)

            근데, 여기서 리턴 값은 엔티티 타입이다 !
         */
        final Optional<TestPracticeAccount> practiceAccount =
                testPracticeAccountRepository.findByEmail(requestForm.getEmail());

        /*
            추출한 값이 존재한다면

            ( 즉, 회원 정보가 있으므로 이미 회원 가입을 한 회원이거나,
            email 값이 중복이므로 사용이 불가하다. )

            null 값을 리턴하라.
         */
        if(practiceAccount.isPresent()){
            log.debug("이미 가입된 회원입니다.");
            return null;
        }

        /*
            추출한 값이 존재하지 않는다면

            ( 즉, 회원 정보가 없으므로 새로운 회원가입이 가능하다 ! )

            전달된 정보를 가지고 엔티티 객체로 만들어서
            repository(=DB)에 save, 저장해라 !

            그러면 회원가입이 완료된 것이다 !
         */
        return testPracticeAccountRepository.save(requestForm.toTestPractice());
    }

    @Override
    public TestPracticeResponseForm login(TestPracticeAccountRequestForm requestForm){
        final Optional<TestPracticeAccount> practiceAccount =
                testPracticeAccountRepository.findByEmail(requestForm.getEmail());

        if(practiceAccount.isEmpty()){
            log.debug("로그인 실패!");
            return new TestPracticeResponseForm(null, null);
        }

        TestPracticeAccount testPracticeAccount = practiceAccount.get();

        if(testPracticeAccount.getPassword().equals(requestForm.getPassword())){
            log.debug("로그인 성공!");
            return new TestPracticeResponseForm(UUID.randomUUID(), requestForm.getAccountRole());
        }

        log.debug("로그인 실패!");
        return new TestPracticeResponseForm(null, null);
    }

}
