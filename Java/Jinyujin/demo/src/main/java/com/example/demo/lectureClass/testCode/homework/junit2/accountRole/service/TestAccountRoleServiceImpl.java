package com.example.demo.lectureClass.testCode.homework.junit2.accountRole.service;

import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRole;
import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.repository.TestAccountRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestAccountRoleServiceImpl implements TestAccountRoleService{

    final TestAccountRoleRepository accountRoleRepository;

    @Override
    public AccountRole whatIsYourType(String role) {

        final Optional<AccountRole> maybeAccountRole =
                accountRoleRepository.findByRole(role);

        if (maybeAccountRole.isEmpty()) {
            return null;
        }

        return maybeAccountRole.get();
    }
}
