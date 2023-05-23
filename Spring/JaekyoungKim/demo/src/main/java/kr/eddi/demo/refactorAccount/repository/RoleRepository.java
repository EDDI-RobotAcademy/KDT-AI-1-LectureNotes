package kr.eddi.demo.refactorAccount.repository;

import kr.eddi.demo.refactorAccount.entity.Role;
import kr.eddi.demo.refactorAccount.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}