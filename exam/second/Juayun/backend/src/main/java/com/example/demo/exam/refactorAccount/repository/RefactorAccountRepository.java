package com.example.demo.exam.refactorAccount.repository;

import com.example.demo.exam.refactorAccount.entity.RefactorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefactorAccountRepository extends JpaRepository<RefactorAccount, Long> {
    Optional<RefactorAccount> findByEmail(String email);
}
