package kr.eddi.demo.lectureClass.fetchType.repository;

import kr.eddi.demo.lectureClass.fetchType.entity.JpaAccount;
import kr.eddi.demo.lectureClass.testCode.account.entity.AccountRole;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<JpaAccount, Long> {
    Optional<JpaAccount> findByEmail(String email);
}
