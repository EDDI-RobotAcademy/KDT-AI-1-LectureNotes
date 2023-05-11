package com.example.demo.lectureClass.testCode.account.repository.admin;

import com.example.demo.lectureClass.testCode.account.entity.admin.TestAdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAdminAccountRepository extends JpaRepository<TestAdminAccount, Long> {
    Optional<TestAdminAccount> findByEmail(String email);
}
