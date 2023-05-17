package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.repository;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity.TestPracticeAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestPracticeAccountRepository extends JpaRepository<TestPracticeAccount, Long> {

    Optional<TestPracticeAccount> findByEmail(String email);

    Optional<TestPracticeAccount> findByPassword(Integer password);

}
