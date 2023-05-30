package kr.eddi.demo.lectureClass.testCode.account.repository;

import kr.eddi.demo.lectureClass.testCode.account.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestAccountRoleRepository extends JpaRepository<AccountRole, Long> {
    List<AccountRole> findAllByRole(String role);
}
