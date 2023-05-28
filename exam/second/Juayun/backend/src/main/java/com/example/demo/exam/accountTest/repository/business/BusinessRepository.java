package com.example.demo.exam.accountTest.repository.business;

import com.example.demo.exam.accountTest.entity.business.BusinessAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<BusinessAccount, Long> {
    Optional<BusinessAccount> findByEmail(String email);
}
