package kr.eddi.demo.RefactorAccount.repository;

import kr.eddi.demo.RefactorAccount.entity.RefactorRole;
import kr.eddi.demo.RefactorAccount.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.Optional;

public interface RefactorRoleRepository extends JpaRepository<RefactorRole , Long> {
    Optional<RefactorRole> findByRoleType(RoleType roleType);
}
