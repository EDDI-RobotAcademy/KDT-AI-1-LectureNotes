package com.example.demo.lectureClass.testCode.lectureWithStudent.repository;

import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<PracticeRegister, Long> {
}
