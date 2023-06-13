package com.example.demo.lectureClass.testCode.account.repository;

import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
    Optional<TestAccount> findByEmail(String email);
}
