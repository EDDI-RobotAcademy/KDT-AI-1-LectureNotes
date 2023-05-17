package com.example.demo.lectureClass.testCode.homework.homework1.repository;

import com.example.demo.lectureClass.testCode.homework.homework1.entity.HomeworkAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeworkAccountRepository extends JpaRepository<HomeworkAccount, Long> {
    Optional<HomeworkAccount> findByEmail(String email);
}
