package kr.jinho.jinhokim.testCode.lecture.repository;

import kr.jinho.jinhokim.testCode.lecture.entity.TestLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestLectureRepository extends JpaRepository<TestLecture, Long> {
    Optional<TestLecture> findByLectureName(String subject);
}
