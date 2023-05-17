package com.example.demo.lectureClass.fetchType.account.rpository;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<JpaAccount,Long> {
    Optional<JpaAccount> findByEmail(String email);
}
