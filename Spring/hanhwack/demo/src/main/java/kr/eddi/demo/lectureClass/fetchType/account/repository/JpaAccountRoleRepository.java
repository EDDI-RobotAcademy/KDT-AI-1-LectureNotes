package kr.eddi.demo.lectureClass.fetchType.account.repository;

import kr.eddi.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {
}