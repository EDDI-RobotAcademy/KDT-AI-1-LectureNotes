package com.example.demo.lectureClass.homework.jUnitBank3.repository;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRoleType;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkJpaRoleRepository extends JpaRepository<HomeworkJpaRole, Long> {
    HomeworkJpaRole findByRoleType(HomeworkJpaAccountRoleType roleType);
}
