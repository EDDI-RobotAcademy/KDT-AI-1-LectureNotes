package com.example.demo.lectureClass.testCode.lectureWithStudent.repository;

import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturePracticeRepository extends JpaRepository<PracticeLecture, Long> {
    Optional<PracticeLecture> findByName(String subject);
}
