package com.example.demo.problem.problem11.account.repository;

import com.example.demo.problem.problem11.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
    Optional<TestAccount> findByEmail(String email);
}