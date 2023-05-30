package com.example.demo.lectureClass.testCode.account.service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.AccountRole;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRoleRepository;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
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
    public TestAccount register(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다.");
            return null;
        }

        return testAccountRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            log.debug("로그인 실패!");
            return new TestAccountLoginResponseForm(null);
        }
        TestAccount account = maybeAccount.get();

        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            return new TestAccountLoginResponseForm(UUID.randomUUID());
        }
        return new TestAccountLoginResponseForm(null);
    }

    @Override
    public TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다.");
            return null;
        }

        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        // 바로 리턴하지않음
        testAccountRoleRepository.save(requestForm.toTestAccountRole(account));

        return account;
    }

    @Override
    public List<TestAccountResponseForm> accountListWithRole(String role) {
        final List<AccountRole> matchedAccountRoleList = testAccountRoleRepository.findAllByRole(role);
        // 여기서 확실하게 repository 가 사용
        // matchedAccountRoleList 여기엔 내가 원하는 값이 들어가 있음
        List<TestAccountResponseForm> responseFormList = new ArrayList<>();

        for (AccountRole accountRole: matchedAccountRoleList) {
            final TestAccount account = accountRole.getAccount();
            responseFormList.add
                    (new TestAccountResponseForm(
                             account.getId(), account.getEmail()));
        }
        return responseFormList;

        // 여기는 JpaAccount 와는 다르게 이미 계정이 있다는 가정을 하고 시작하기 때문에
        // 계정이 없다는 가정자체가 필요가 없음
    }
}
