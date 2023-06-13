package kr.jinho.jinhokim.testCode.student.repository;

import kr.jinho.jinhokim.testCode.student.entity.TestStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestStudentRepository extends JpaRepository<TestStudent, Long> {
    Optional<TestStudent> findByName(String name);
}
