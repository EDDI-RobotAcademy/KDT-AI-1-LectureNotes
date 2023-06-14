package kr.jinho.jinhokim.testCode.account.repository;

import kr.jinho.jinhokim.testCode.account.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestAccountRoleRepository extends JpaRepository<AccountRole, Long> {
    List<AccountRole> findAllByRole(String role);
}
