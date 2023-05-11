package kr.eddi.demo.lectureClass.testCode.account.repository;

import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestTypeAccountRepository extends JpaRepository<TestAccountType, Long> {
    Optional<TestAccountType> findByEmail(String email);
}
