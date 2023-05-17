package com.example.demo.lectureClass.refactorAccount.repository;

import com.example.demo.lectureClass.refactorAccount.entity.RoleType;
import com.example.demo.lectureClass.refactorAccount.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleType(RoleType roleType);

}
