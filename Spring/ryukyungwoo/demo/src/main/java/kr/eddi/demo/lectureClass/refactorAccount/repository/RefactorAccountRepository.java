package kr.eddi.demo.lectureClass.refactorAccount.repository;

import kr.eddi.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefactorAccountRepository extends JpaRepository<RefactorAccount, Long> {
}
