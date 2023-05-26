package kr.eddi.demo.problem1319.Account.repository;

import kr.eddi.demo.problem1319.Account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
     Optional<Account> findByEmail(String email) ;
}
