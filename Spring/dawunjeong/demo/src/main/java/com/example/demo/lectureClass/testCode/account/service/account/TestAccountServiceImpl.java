package com.example.demo.lectureClass.testCode.account.service.account;

import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.account.AccountRole;
import com.example.demo.lectureClass.testCode.account.entity.account.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.account.TestAccountRepository;
import com.example.demo.lectureClass.testCode.account.repository.account.TestAccountRoleRepository;
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
        final Optional<TestAccount> maybeConsumerAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeConsumerAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testAccountRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeConsumerAccount
                = testAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeConsumerAccount.isEmpty()) {
            log.debug("로그인 실패!");
            return new TestAccountLoginResponseForm(null);
        }

        TestAccount account = maybeConsumerAccount.get();

        if(account.getPassword().equals(requestForm.getPassword())){
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
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        testAccountRoleRepository.save(requestForm.toTestAccountRole(account));

        return account;
    }

    @Override
    public List<TestAccountResponseForm> accountListWithRole(String role) {
        final List<AccountRole> matchedAccountRoleList = testAccountRoleRepository.findAllByRole(role);

        List<TestAccountResponseForm> responseFormList = new ArrayList<>();

        for(AccountRole accountRole: matchedAccountRoleList) {
            final TestAccount account = accountRole.getTestAccount();
            responseFormList.add(
                    new TestAccountResponseForm(
                            account.getId(), account.getEmail()));
        }

        return responseFormList;
    }

}
