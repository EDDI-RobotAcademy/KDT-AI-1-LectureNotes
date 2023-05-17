package com.example.demo.exam.refactorAccount.repository;

import com.example.demo.exam.refactorAccount.entity.Role;
import com.example.demo.exam.refactorAccount.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
