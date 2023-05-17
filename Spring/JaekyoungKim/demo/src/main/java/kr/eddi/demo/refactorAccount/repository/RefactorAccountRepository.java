package kr.eddi.demo.refactorAccount.repository;

import kr.eddi.demo.refactorAccount.entity.RefactorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefactorAccountRepository extends JpaRepository<RefactorAccount,Long> {
}
