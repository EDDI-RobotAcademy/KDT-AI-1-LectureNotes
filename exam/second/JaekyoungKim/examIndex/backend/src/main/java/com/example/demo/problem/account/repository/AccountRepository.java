package com.example.demo.problem.account.repository;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.account.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
