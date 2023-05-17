package com.example.demo.lectureClass.homework.repository;

import com.example.demo.lectureClass.homework.entity.Role;
import com.example.demo.lectureClass.homework.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleType(RoleType roleType);
}
