package com.example.demo.problem.repository;

import com.example.demo.problem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByEmail(String email);

}
