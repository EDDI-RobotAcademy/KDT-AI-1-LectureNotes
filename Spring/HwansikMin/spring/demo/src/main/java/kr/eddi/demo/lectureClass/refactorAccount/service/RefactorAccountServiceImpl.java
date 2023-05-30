package kr.eddi.demo.lectureClass.refactorAccount.service;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.*;
import kr.eddi.demo.lectureClass.refactorAccount.entity.RefactorAccountRole;
import kr.eddi.demo.lectureClass.refactorAccount.entity.Role;
import kr.eddi.demo.lectureClass.refactorAccount.repository.RefactorAccountRepository;
import kr.eddi.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import kr.eddi.demo.lectureClass.refactorAccount.repository.RefactorAccountRoleRepository;
import kr.eddi.demo.lectureClass.refactorAccount.repository.RoleRepository;
import kr.eddi.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;
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
