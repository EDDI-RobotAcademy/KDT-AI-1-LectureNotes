package com.example.demo.evaluation.problem10_14_17_20.repository;

import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
