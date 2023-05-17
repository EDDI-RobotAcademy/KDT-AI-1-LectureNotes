package com.example.demo.lectureClass.testCode.account.repository.account;

import com.example.demo.lectureClass.testCode.account.entity.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestAccountRoleRepository extends JpaRepository<AccountRole, Long> {
    List<AccountRole> findAllByRole(String role);
}
