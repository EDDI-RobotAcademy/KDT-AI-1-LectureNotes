package com.example.demo.lectureClass.testCode.student.repository;

import com.example.demo.lectureClass.testCode.student.entity.TestStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStudentRepository extends JpaRepository<TestStudent, Long> {
}
