package com.example.demo.exam.refactorAccount.repository;

import com.example.demo.exam.refactorAccount.entity.AccountBusiness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountBusinessRepository extends JpaRepository<AccountBusiness, Long> {
    Optional<AccountBusiness> findByEmail(String email);
}
