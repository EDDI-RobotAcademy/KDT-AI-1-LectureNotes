package kr.eddi.demo.fetchType.account.repository;


import kr.eddi.demo.fetchType.account.entity.JpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<JpaAccount, Long> {
    Optional<JpaAccount> findByEmail(String email);
}