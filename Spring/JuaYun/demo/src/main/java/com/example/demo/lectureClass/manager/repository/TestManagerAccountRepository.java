package com.example.demo.lectureClass.manager.repository;

import com.example.demo.lectureClass.manager.entity.TestManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestManagerAccountRepository extends JpaRepository<TestManager, Long> {

    Optional<TestManager> findByManagerEmail(String managerEmail);

}
