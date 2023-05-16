package com.example.demo.lectureClass.lecture.repository;

import com.example.demo.lectureClass.lecture.entity.TestLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestLectureRepository extends JpaRepository<TestLecture, Long> {
    Optional<TestLecture> findByLectureName(String subject);
}
