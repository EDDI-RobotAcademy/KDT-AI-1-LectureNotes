package com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.repository;

import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.entity.TestAdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAdminAccountRepository extends JpaRepository<TestAdminAccount, Long> {
    Optional<TestAdminAccount> findByEmail(String email);
}
