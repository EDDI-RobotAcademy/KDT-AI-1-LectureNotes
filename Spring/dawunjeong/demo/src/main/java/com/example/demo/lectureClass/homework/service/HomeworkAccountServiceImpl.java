package com.example.demo.lectureClass.homework.service;

import com.example.demo.lectureClass.aggregateRoot.entity.Category;
import com.example.demo.lectureClass.aggregateRoot.entity.FoodCategory;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.homework.controller.form.HomeworkAccountRequestForm;
import com.example.demo.lectureClass.homework.entity.HomeworkAccount;
import com.example.demo.lectureClass.homework.entity.HomeworkAccountRole;
import com.example.demo.lectureClass.homework.entity.Role;
import com.example.demo.lectureClass.homework.repository.HomeworkAccountRepository;
import com.example.demo.lectureClass.homework.repository.HomeworkAccountRoleRepository;
import com.example.demo.lectureClass.homework.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeworkAccountServiceImpl implements HomeworkAccountService{

    @Autowired
    private HomeworkAccountRepository homeworkAccountRepository;
    @Autowired
    private HomeworkAccountRoleRepository homeworkAccountRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public HomeworkAccount register(HomeworkAccountRequestForm requestForm) {
        final Optional<HomeworkAccount> maybeAccount =
                homeworkAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final HomeworkAccount account = requestForm.toHomeworkAccount();
        homeworkAccountRepository.save(account);

        final Role role = roleRepository.findByRoleType(requestForm.getRoleType());
        final HomeworkAccountRole homeworkAccountRole = new HomeworkAccountRole(account, role);
        homeworkAccountRoleRepository.save(homeworkAccountRole);

        return account;
    }
}
