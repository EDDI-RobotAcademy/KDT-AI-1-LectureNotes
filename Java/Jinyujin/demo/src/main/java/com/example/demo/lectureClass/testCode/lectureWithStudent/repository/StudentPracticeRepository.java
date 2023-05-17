package com.example.demo.lectureClass.testCode.lectureWithStudent.repository;

import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentPracticeRepository extends JpaRepository<PracticeStudent, Long> {
    Optional<PracticeStudent> findByName(String name);
}
