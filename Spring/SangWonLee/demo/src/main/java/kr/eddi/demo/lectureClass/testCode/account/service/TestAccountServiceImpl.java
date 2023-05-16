package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.AccountRole;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRoleRepository;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {

    final private TestAccountRepository testAccountRepository;
    final private TestAccountRoleRepository testAccountRoleRepository;
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
            // 로그인 성공이 되면 UUID.randomUUID() 를 생성
        }

        return new TestAccountLoginResponseForm(null);
        // 이메일 아이디는 같지만, 비밀번호가 다른 경우

    }
    @Override
    public TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());
        // 받아온 정보값에서 email을 인자로 findByEmail 메소드 실행
        // DB에 있는 값이면 속이 차있는 Optional이고, 없는 값이면 빈 Optional일 것임

        if (maybeAccount.isPresent()) { // 속이 차있으면 email이 존재하는거니까
            log.debug("이미 가입된 회원입니다!");
            return null; // 테스트 실패
        }
        // 이 밑은 빈 Optional 이니까. DB에 존재하지 않는 email이므로 진행

        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        // requestForm 으로 받아온 매개변수로 toTestAccount 메소드 실행
        // (TestAccount 객체로 만들기) 그 후 DB에 저장 (DB에 test_account 테이블에 저장)

        testAccountRoleRepository.save(requestForm.toTestAccountRole(account));
        // 위의 account로 TestAccountWithRoleRequestForm(requestForm 임)객체를 사용해서
        // toTestAccountRole 메소드 실행
        // (AccountRole 객체로 만들기) 그 후 DB에 저장 (DB에 account_role 테이블에 저장)

        return account;
    }

    @Override
    public List<TestAccountResponseForm> accountListWithRole(String role) {
        final List<AccountRole> matchedAccountRoleList = testAccountRoleRepository.findAllByRole(role);
        // 받아온 role로 testAccountRoleRepository 가서 DB에 일치하는게 있는지 다 확인 후 AccountRole 객체로 저장

        List<TestAccountResponseForm> responseFormList = new ArrayList<>();

        for (AccountRole accountRole: matchedAccountRoleList) {
            // DB에서 가져온 정보 만큼 반복
            final TestAccount account = accountRole.getAccount();
            // account
            responseFormList.add(
                    new TestAccountResponseForm(
                            account.getId(), account.getEmail()));
        }

        return responseFormList;
    }

}