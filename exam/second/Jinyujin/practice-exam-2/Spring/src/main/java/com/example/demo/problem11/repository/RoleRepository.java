package com.example.demo.problem11.repository;

import com.example.demo.problem11.entity.Role;
import com.example.demo.problem11.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
