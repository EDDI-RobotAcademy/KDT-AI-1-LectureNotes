package com.example.demo.lectureClass.refactorAccount.service;

import com.example.demo.lectureClass.refactorAccount.entity.RefactorAccountRole;
import com.example.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import com.example.demo.lectureClass.refactorAccount.entity.Role;
import com.example.demo.lectureClass.refactorAccount.repository.RefactorAccountRepository;
import com.example.demo.lectureClass.refactorAccount.repository.RefactorAccountRoleRepository;
import com.example.demo.lectureClass.refactorAccount.repository.RoleRepository;
import com.example.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefactorAccountServiceImpl implements RefactorAccountService{
    final private RefactorAccountRepository accountRepository;
    final private RefactorAccountRoleRepository accountRoleRepository;
    final private RoleRepository roleRepository;
    @Override
    public Boolean register(RefactorAccountRegisterRequest request){
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
