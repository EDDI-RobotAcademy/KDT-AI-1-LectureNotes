package com.example.demo.exam.exam10To30.account.repository;

import com.example.demo.exam.exam10To30.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
