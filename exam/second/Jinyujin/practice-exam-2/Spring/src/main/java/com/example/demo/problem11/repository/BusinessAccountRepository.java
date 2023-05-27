package com.example.demo.problem11.repository;

import com.example.demo.problem11.entity.BusinessAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessAccountRepository extends JpaRepository<BusinessAccount, Long> {
    Optional<BusinessAccount> findByEmail(String email);
}
