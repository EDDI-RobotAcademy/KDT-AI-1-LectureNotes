package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import com.example.demo.lectureClass.fetchType.account.repository.JpaAccountRepository;
import com.example.demo.lectureClass.fetchType.account.repository.JpaAccountRoleRepository;
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

        final JpaAccount account =
                accountRepository.save(requestForm.toJpaAccount());

        accountRoleRepository.save(requestForm.toJpaAccountRole((account)));

        return account;
    }

    @Override
    public List<JpaAccountResponseForm> accountListWithRole(String role) {
        final List<JpaAccountRole> matchedAccountRoleList = accountRoleRepository.findAllByRole(role);
        log.info("matchedAccountRoleList: " + matchedAccountRoleList);

        List<JpaAccountResponseForm> responseFormList = new ArrayList<>();

        for (JpaAccountRole accountRole: matchedAccountRoleList) {
            final Optional<JpaAccount> maybeAccount = accountRepository.findById(accountRole.getId());

            // isEmpty() - 없다면
            if (maybeAccount.isEmpty()) {
                return null;
            }

            final JpaAccount account = maybeAccount.get();
            responseFormList.add(new JpaAccountResponseForm(account.getId(), account.getEmail()));
        }

        return responseFormList;
    }
}










