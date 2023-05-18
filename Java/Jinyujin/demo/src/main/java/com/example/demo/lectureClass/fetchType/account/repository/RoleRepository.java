package com.example.demo.lectureClass.fetchType.account.repository;

import com.example.demo.lectureClass.fetchType.account.entity.Role;
import com.example.demo.lectureClass.fetchType.account.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleType(RoleType roleType);
}
