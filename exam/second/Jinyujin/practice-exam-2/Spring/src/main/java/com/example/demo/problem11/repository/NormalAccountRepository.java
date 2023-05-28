package com.example.demo.problem11.repository;

import com.example.demo.problem11.entity.NormalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NormalAccountRepository extends JpaRepository<NormalAccount, Long> {
    Optional<NormalAccount> findByEmail(String email);
}
