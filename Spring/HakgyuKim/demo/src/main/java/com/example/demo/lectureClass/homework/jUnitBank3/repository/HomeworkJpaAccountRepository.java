package com.example.demo.lectureClass.homework.jUnitBank3.repository;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeworkJpaAccountRepository extends JpaRepository<HomeworkJpaAccount, Long> {
    Optional<HomeworkJpaAccount> findByEmail(String email);
}
