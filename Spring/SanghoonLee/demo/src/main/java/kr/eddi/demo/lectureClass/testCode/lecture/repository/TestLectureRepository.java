package kr.eddi.demo.lectureClass.testCode.lecture.repository;

import kr.eddi.demo.lectureClass.testCode.lecture.entity.TestLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestLectureRepository extends JpaRepository<TestLecture, Long> {
}
