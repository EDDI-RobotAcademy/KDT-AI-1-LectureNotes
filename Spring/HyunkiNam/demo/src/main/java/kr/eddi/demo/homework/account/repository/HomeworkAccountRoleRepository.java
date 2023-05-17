package kr.eddi.demo.homework.account.repository;

import kr.eddi.demo.homework.account.entity.HomeworkAccountRole;
import kr.eddi.demo.homework.account.entity.HomeworkAccountRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkAccountRoleRepository extends JpaRepository<HomeworkAccountRole, Long> {

    HomeworkAccountRole findByAccountRoleType(HomeworkAccountRoleType roleType);
}