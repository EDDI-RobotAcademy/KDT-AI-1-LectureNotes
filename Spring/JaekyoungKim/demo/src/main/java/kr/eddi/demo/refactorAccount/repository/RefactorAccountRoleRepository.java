package kr.eddi.demo.refactorAccount.repository;

import kr.eddi.demo.refactorAccount.entity.RefactorAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefactorAccountRoleRepository extends JpaRepository<RefactorAccountRole, Long> {
}