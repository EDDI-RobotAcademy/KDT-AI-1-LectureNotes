package com.example.demo.lectureClass.refactorAccount.service;

import com.example.demo.lectureClass.aggregateRoot.food.entity.*;
import com.example.demo.lectureClass.refactorAccount.entity.RefactorAccountRole;
import com.example.demo.lectureClass.refactorAccount.entity.Role;
import com.example.demo.lectureClass.refactorAccount.repository.RefactorAccountRepository;
import com.example.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import com.example.demo.lectureClass.refactorAccount.repository.RefactorAccountRoleRepository;
import com.example.demo.lectureClass.refactorAccount.repository.RoleRepository;
import com.example.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefactorAccountServiceImpl implements RefactorAccountService {

    final private RefactorAccountRepository accountRepository;
    final private RefactorAccountRoleRepository accountRoleRepository;
    final private RoleRepository roleRepository;

    @Override
    public Boolean register(RefactorAccountRegisterRequest request) {
        RefactorAccount account = accountRepository.save(request.toRefactorAccount());

        final Role role = roleRepository.findByRoleType(
                request.getRoleType()).get();
        final RefactorAccountRole accountRole =
                new RefactorAccountRole(account, role);
        accountRoleRepository.save(accountRole);

        account.setAccountRole(accountRole);

        return true;

    }
}
