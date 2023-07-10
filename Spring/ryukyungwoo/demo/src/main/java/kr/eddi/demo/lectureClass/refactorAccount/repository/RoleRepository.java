package kr.eddi.demo.lectureClass.refactorAccount.repository;

import kr.eddi.demo.lectureClass.refactorAccount.entity.Role;
import kr.eddi.demo.lectureClass.refactorAccount.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
