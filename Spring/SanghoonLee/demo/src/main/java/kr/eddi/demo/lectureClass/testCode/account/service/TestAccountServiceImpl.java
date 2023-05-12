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
    public TestAccount register(TestAccountRequestForm requestForm) {
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
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

        if (maybeAccount.isPresent()) {
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

        for (AccountRole accountRole: matchedAccountRoleList) {
            final TestAccount account = accountRole.getAccount();
            responseFormList.add(
                    new TestAccountResponseForm(
                            account.getId(), account.getEmail()));
        }

        return responseFormList;
    }
}
