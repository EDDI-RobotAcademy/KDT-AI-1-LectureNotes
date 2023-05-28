package com.example.demo.evaluation.problem10_14_17_20.repository;

import com.example.demo.evaluation.problem10_14_17_20.entity.Role;
import com.example.demo.evaluation.problem10_14_17_20.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleType(RoleType roleType);
}
