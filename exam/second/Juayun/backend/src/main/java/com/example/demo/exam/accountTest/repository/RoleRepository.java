package com.example.demo.exam.accountTest.repository;

import com.example.demo.exam.accountTest.entity.Role;
import com.example.demo.exam.accountTest.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);

}
