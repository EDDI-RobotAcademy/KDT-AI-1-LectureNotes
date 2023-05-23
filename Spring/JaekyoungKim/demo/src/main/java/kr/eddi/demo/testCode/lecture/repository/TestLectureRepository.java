package kr.eddi.demo.testCode.lecture.repository;

import kr.eddi.demo.testCode.lecture.entity.TestLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestLectureRepository extends JpaRepository<TestLecture, Long> {
    Optional<TestLecture> findByLectureName(String subject);
}