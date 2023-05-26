package com.example.demo.exam.accountTest.repository.account;

import com.example.demo.exam.accountTest.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
