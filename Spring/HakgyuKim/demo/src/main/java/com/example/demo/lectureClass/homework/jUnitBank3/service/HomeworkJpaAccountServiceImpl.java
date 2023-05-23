package com.example.demo.lectureClass.homework.jUnitBank3.service;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccount;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRole;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaRole;
import com.example.demo.lectureClass.homework.jUnitBank3.form.HomeworkJpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.homework.jUnitBank3.repository.HomeworkJpaAccountRepository;
import com.example.demo.lectureClass.homework.jUnitBank3.repository.HomeworkJpaAccountRoleRepository;
import com.example.demo.lectureClass.homework.jUnitBank3.repository.HomeworkJpaRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeworkJpaAccountServiceImpl implements HomeworkJpaAccountService {
    @Autowired
    private HomeworkJpaAccountRepository accountRepository;
    @Autowired
    private HomeworkJpaAccountRoleRepository accountRoleRepository;
    @Autowired
    private HomeworkJpaRoleRepository roleRepository;

    @Override
    public HomeworkJpaAccount registerWithRole(HomeworkJpaAccountWithRoleRequestForm requestForm) {
        final Optional<HomeworkJpaAccount> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());
        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }
        final HomeworkJpaAccount account = accountRepository.save(requestForm.toJpaAccount());

        final HomeworkJpaRole homeworkJpaRole = roleRepository.findByRoleType(
                requestForm.getRoleType());
        final HomeworkJpaAccountRole homeworkJpaAccountRole = new HomeworkJpaAccountRole(account, homeworkJpaRole);

        accountRoleRepository.save(homeworkJpaAccountRole);

        return account;
    }

}
