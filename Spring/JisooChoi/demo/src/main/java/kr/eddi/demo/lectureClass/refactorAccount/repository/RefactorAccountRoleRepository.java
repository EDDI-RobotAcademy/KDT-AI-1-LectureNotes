package kr.eddi.demo.lectureClass.refactorAccount.repository;

import kr.eddi.demo.lectureClass.refactorAccount.entity.RefactorAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefactorAccountRoleRepository extends JpaRepository<RefactorAccountRole, Long> {
}