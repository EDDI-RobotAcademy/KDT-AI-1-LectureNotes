package com.example.demo.lectureClass.homework.jUnitBank3.repository;

import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRole;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRoleType;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeworkJpaAccountRoleRepository extends JpaRepository<HomeworkJpaAccountRole, Long> {
}
