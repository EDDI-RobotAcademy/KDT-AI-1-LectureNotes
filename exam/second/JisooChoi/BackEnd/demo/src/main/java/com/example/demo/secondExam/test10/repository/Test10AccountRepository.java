package com.example.demo.secondExam.test10.repository;

import com.example.demo.secondExam.test10.entity.Test10Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Test10AccountRepository extends JpaRepository<Test10Account, Long> {
    Optional<Test10Account> findByEmail(String email);

    Optional<Test10Account> findByPassword(Integer password);
}
