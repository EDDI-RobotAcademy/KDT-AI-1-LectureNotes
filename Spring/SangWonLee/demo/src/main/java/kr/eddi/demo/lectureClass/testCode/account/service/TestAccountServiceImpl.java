package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository;
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
    public TestAccount register(TestAccountRequestForm requestForm) { // TestAccountRequestForm 객체를 인자로 받아서
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());
        // testAccountRepository.findByEmail(requestForm.getEmail()) 메소드를 호출하여
        // 이메일로 회원 정보를 조회한 후 Optional<TestAccount> 객체를 반환.

        if (maybeAccount.isPresent()) {
            // maybeAccount.isPresent() 메소드를 사용하여 값이 존재하면 true, 없으면 false로 반환
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testAccountRepository.save(requestForm.toTestAccount());
        // jpa를 사용하여 db에 저장
    }

    @Override
    public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());
        // 이메일이 있나 없나?

        if (maybeAccount.isEmpty()) {
            // 이메일이 없다면
            log.debug("로그인 실패!");
            return new TestAccountLoginResponseForm(null);
            // userToken을 null로 반환
        }

        // 이 밑은 회원정보가 있다는 거겠지?
        TestAccount account = maybeAccount.get(); // TestAccount 객체를 가져옴

        if (account.getPassword().equals(requestForm.getPassword())) {
            // 가져온 객체의 비밀번호를 가져와서 인자로 받은 requestForm의 비밀번호랑 비교해서 같으면
            log.debug("로그인 성공!");
            return new TestAccountLoginResponseForm(UUID.randomUUID());
        }

        return new TestAccountLoginResponseForm(null);
        // 이메일 아이디는 같지만, 비밀번호가 다른 경우

    }
}