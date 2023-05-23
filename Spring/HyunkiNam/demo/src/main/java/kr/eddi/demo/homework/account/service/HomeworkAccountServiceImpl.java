package kr.eddi.demo.homework.account.service;

import kr.eddi.demo.homework.account.entity.HomeworkAccount;
import kr.eddi.demo.homework.account.entity.HomeworkAccountRole;
import kr.eddi.demo.homework.account.entity.HomeworkAccountType;
import kr.eddi.demo.homework.account.controller.form.HomeworkAccountWithRoleRequestForm;
import kr.eddi.demo.homework.account.repository.HomeworkAccountRepository;
import kr.eddi.demo.homework.account.repository.HomeworkAccountRoleRepository;
import kr.eddi.demo.homework.account.repository.HomeworkAccountTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeworkAccountServiceImpl implements HomeworkAccountService {

    @Autowired
    private HomeworkAccountRepository accountRepository;

    @Autowired
    private HomeworkAccountRoleRepository accountRoleRepository;

    @Autowired
    private HomeworkAccountTypeRepository accountTypeRepository;

    @Override
    public HomeworkAccount register(HomeworkAccountWithRoleRequestForm request) {
        // 1. 식재료 Entity 및 Image 처리
        final HomeworkAccount account = request.toHomeworkAccount();

        accountRepository.save(account);
        // 3. 카테고리 처리
        final HomeworkAccountRole accountRole = accountRoleRepository.findByAccountRoleType(
                request.getAccountRoleType());
        final HomeworkAccountType accountType =
                new HomeworkAccountType(account, accountRole);

        accountTypeRepository.save(accountType);

        return account;
    }
}