package com.example.demo.lectureClass.account.repository;

import com.example.demo.lectureClass.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
    Optional<TestAccount> findByEmail(String email);
}
