package kr.eddi.demo.lectureClass.testCode.account.repository;

import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
}