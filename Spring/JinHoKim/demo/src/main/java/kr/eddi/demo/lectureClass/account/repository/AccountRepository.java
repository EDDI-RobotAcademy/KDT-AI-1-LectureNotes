package kr.eddi.demo.lectureClass.account.repository;

import kr.eddi.demo.lectureClass.account.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<MemberAccount, Long> {
    Optional<MemberAccount> findByEmail(String email);
}
