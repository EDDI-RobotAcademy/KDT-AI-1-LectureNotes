package kr.eddi.demo.RefactorAccount.repository;

import kr.eddi.demo.RefactorAccount.entity.RefactorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefactorAccountRepository extends JpaRepository<RefactorAccount,Long> {
    Optional<RefactorAccount> findByEmail(String email);
}
