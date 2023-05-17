package com.example.demo.lectureClass.homework.repository;

import com.example.demo.lectureClass.homework.entity.HomeworkAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeworkAccountRepository extends JpaRepository<HomeworkAccount, Long> {
    Optional<HomeworkAccount> findByEmail(String email);
}
