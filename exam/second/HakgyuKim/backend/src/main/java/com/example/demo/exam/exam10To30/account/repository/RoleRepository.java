package com.example.demo.exam.exam10To30.account.repository;

import com.example.demo.exam.exam10To30.account.entity.Role;
import com.example.demo.exam.exam10To30.account.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleType(RoleType roleType);
}
