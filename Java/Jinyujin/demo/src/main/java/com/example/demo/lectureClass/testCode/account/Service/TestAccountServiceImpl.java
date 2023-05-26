package com.example.demo.lectureClass.testCode.account.Service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.AccountRole;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRoleRepository;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.controller.form.TestAccountRoleRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRoleHomework;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestAccountServiceImpl implements TestAccountService{

    final private TestAccountRepository testAccountRepository;
    final private TestAccountRoleRepository testAccountRoleRepository;

    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {

        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            // 지금까지 log.info를 써왔는데 이건 로그인이나 상태 변경과 같은 정보성 메세지
            // log.debug는 개발시 디버깅 목적으로 출력하고
            // debug로 출력할 시 info정보까지 출력된다고 함
            // 오류 있으면 오류도 찾고 정보도 받을 수 있으니
            // 목적에 맞게 활용하면 될 듯
            // 그리고 println말고 log로 찍는 이유는 정보 더 많이 나오고 더 좋대 걍
            return null;
        }
        // 처음에 가입할 때는 값이 없을 테니까 바로 아래 return 값이 반환
        // 그 후 update 처리한 후 중복을 똑같은 이메일로 확인하면 return null하면서 끝
        // 그리고 그 반환된 null을 AccountTest에서 사용하여
        // null이라면 == 중복된 이메일이라면 중복test pass하는 것

        return testAccountRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            log.info("로그인 실패!");
            return new TestAccountLoginResponseForm(null);
        }
        // 이메일 찾아서 없으면 null값으로 반환

        TestAccount account = maybeAccount.get();
        // 있으면 account에 저장
        // TestAccount 형식으로 저장하면 그 형식에 맞춰서 다 들고 오게 됨

        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            return new TestAccountLoginResponseForm(UUID.randomUUID());
        }
        // 비번까지 같으면 랜덤UUID 반환
        // TestAccountLoginResponseForm의 userToken에 UUID.randomUUID()값을 넣는 객체를 반환

        return new TestAccountLoginResponseForm(null);
        // 여기는 왜 갑자기 null값을 줘?
        // password가 다른 경우라서!
    }

//    @Override
//    public TestAccount whatIsYourAccount(TestAccountRoleRequestForm accountRoleRequestForm, AccountRoleHomework accountRoleHomework) {
//
//        final Optional<TestAccount> maybeAccount =
//                testAccountRepository.findByEmail(accountRoleRequestForm.getEmail());
//
//        if (maybeAccount.isEmpty()) {
//            log.debug("없는 회원입니다");
//            return null;
//        }
//
//        TestAccount testAccount = maybeAccount.get();
//        testAccount.setAccountRole(accountRoleHomework);
//
//        return testAccountRepository.save(testAccount);
//    }

    @Override
    public TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        testAccountRoleRepository.save(requestForm.toTestAccountRole(account));

        return account;
        // 쌤은 회원 등록을 하고 account저장소에 저장하고
        // 그걸 다시 role저장소에 저장함
    }

    @Override
    public List<TestAccountResponseForm> accountListWithRole(String role) {

        List<AccountRole> matchedAccountRoleList = testAccountRoleRepository.findAllByRole(role);

        List<TestAccountResponseForm> responseFormList = new ArrayList<>();
        // 위에서 받아온 것 아래 폼에 정보 가공해서 리턴해줘야 하는 것 -> foreach

        for (AccountRole accountRole : matchedAccountRoleList) {
            final TestAccount account = accountRole.getAccount();
            responseFormList.add(
                    new TestAccountResponseForm(account.getId(), account.getEmail()));
        }

        return responseFormList;
    }

}
