package com.example.demo.lectureClass.testCode.lecture.repository;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestLectureRepository extends JpaRepository<TestLecture, Long> {
}
