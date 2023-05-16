package kr.eddi.demo.fetchType.account.service;

import kr.eddi.demo.fetchType.account.controller.form.JpaAccountResponseForm;
import kr.eddi.demo.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import kr.eddi.demo.fetchType.account.entity.JpaAccount;
import kr.eddi.demo.fetchType.account.entity.JpaAccountRole;
import kr.eddi.demo.fetchType.account.repository.JpaAccountRepository;
import kr.eddi.demo.fetchType.account.repository.JpaAccountRoleRepository;
import kr.eddi.demo.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class JpaAccountServiceImpl implements JpaAccountService {

    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private JpaAccountRoleRepository accountRoleRepository;

    @Override
    public JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm) {
        final Optional<JpaAccount> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final JpaAccount account = accountRepository.save(requestForm.toJpaAccount());
        accountRoleRepository.save(requestForm.toJpaAccountRole(account));

        return account;
    }

    @Override
    public List<JpaAccountResponseForm> accountListWithRole(String role) {
        final List<JpaAccountRole> matchedAccountRoleList = accountRoleRepository.findAllByRole(role);
        log.info("matchedAccountRoleList: " + matchedAccountRoleList);
        // 반환해 줌 리스폰스 폼 리스트 만들어줌
        List<JpaAccountResponseForm> responseFormList = new ArrayList<>();
        // 어카운트 롤 리스트의 어카운트 롤 만큼 반복한다.
        for (JpaAccountRole accountRole: matchedAccountRoleList) {
            final Optional<JpaAccount> maybeAccount = accountRepository.findById(accountRole.getId());
            // 어카운트 롤의 아이디로 검색한 어카운트를 반응 폼에 넣어준다.
            if (maybeAccount.isEmpty()) {
                return null;
            }
            // 방은 메이비 어카운트를 어카운트에 넣어주고 리스폰스폼에
            // 가져온 account의 아이디와 account의 이메일을 리스트에 넣어준다.
            final JpaAccount account = maybeAccount.get();
            responseFormList.add(
                    new JpaAccountResponseForm(
                            account.getId(), account.getEmail()));
        }
        //리스트 반환해준다.
        return responseFormList;
    }
}