package kr.eddi.demo.account.repository;

import kr.eddi.demo.account.entity.MemberAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<MemberAccount, Long> {
    Optional<MemberAccount> findByEmail(String email);
}