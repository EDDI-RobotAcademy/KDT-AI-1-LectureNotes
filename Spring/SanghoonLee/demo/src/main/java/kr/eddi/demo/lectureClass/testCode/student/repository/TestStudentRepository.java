package kr.eddi.demo.lectureClass.testCode.student.repository;

import kr.eddi.demo.lectureClass.testCode.student.entity.TestStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStudentRepository extends JpaRepository<TestStudent, Long> {
}
