package com.example.demo.lectureClass.testCode.homework.junit2.accountRole.service;

import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRoleHomework;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.repository.TestAccountRoleRepositoryHomework;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestAccountRoleServiceImpl implements TestAccountRoleService{

    final TestAccountRoleRepositoryHomework accountRoleRepository;

    @Override
    public AccountRoleHomework whatIsYourType(String role) {

        final Optional<AccountRoleHomework> maybeAccountRole =
                accountRoleRepository.findByRole(role);

        if (maybeAccountRole.isEmpty()) {
            return null;
        }

        return maybeAccountRole.get();
    }
}
