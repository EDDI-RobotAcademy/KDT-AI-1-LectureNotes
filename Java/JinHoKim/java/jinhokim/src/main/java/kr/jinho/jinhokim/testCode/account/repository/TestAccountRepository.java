package kr.jinho.jinhokim.testCode.account.repository;

import kr.jinho.jinhokim.testCode.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAccountRepository extends JpaRepository<TestAccount,Long> {
    Optional<TestAccount> findByEmail(String email);
}
