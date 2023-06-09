package kr.eddi.demo.lectureClass.testCode.time.repository;

import kr.eddi.demo.lectureClass.testCode.time.entity.TimeTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTestRepository extends JpaRepository<TimeTest, Long> {
}
