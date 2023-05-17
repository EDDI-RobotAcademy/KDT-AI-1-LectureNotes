package com.example.demo.exam.refactorAccount.service;

import com.example.demo.exam.refactorAccount.controller.form.RefactorAccountRegisterRequestForm;
import com.example.demo.exam.refactorAccount.entity.RefactorAccount;
import com.example.demo.exam.refactorAccount.controller.form.RefactorAccountLoginResponseForm;
import com.example.demo.exam.refactorAccount.entity.RefactorAccountRole;
import com.example.demo.exam.refactorAccount.entity.Role;
import com.example.demo.exam.refactorAccount.form.RefactorAccountRegisterRequest;
import com.example.demo.exam.refactorAccount.repository.RefactorAccountRepository;
import com.example.demo.exam.refactorAccount.repository.RefactorAccountRoleRepository;
import com.example.demo.exam.refactorAccount.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefactorAccountServiceImpl implements RefactorAccountService{

    final private RefactorAccountRepository accountRepository;
    final private RefactorAccountRoleRepository accountRoleRepository;
    final private RoleRepository roleRepository;


    @Override
    public Boolean register(RefactorAccountRegisterRequest request) {
        RefactorAccount account = accountRepository.save(request.toRefactorAccount());

        final Role role = roleRepository.findByRoleType(request.getRoleType()).get();
        final RefactorAccountRole accountRole = new RefactorAccountRole(account, role);
        accountRoleRepository.save(accountRole);

        account.setAccountRole(accountRole);

        return true;
    }

    @Override
    public RefactorAccountLoginResponseForm login(RefactorAccountRegisterRequestForm requestForm) {
        final Optional<RefactorAccount> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            log.debug("로그인 실패!");
            return new RefactorAccountLoginResponseForm(null);
        }
        RefactorAccount account = maybeAccount.get();

        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            return new RefactorAccountLoginResponseForm(UUID.randomUUID());
        }
        return new RefactorAccountLoginResponseForm(null);
    }

}
