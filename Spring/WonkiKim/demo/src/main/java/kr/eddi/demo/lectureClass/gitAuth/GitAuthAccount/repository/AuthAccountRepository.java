package kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.repository;

import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.entity.AuthAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthAccountRepository extends JpaRepository<AuthAccount, Long> {
}
