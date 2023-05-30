package com.example.demo.lectureClass.refactorAccount.repository;

import com.example.demo.lectureClass.refactorAccount.entity.RefactorAccountRole;
import com.example.demo.lectureClass.refactorAccount.entity.Role;
import com.example.demo.lectureClass.refactorAccount.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefactorAccountRoleRepository extends JpaRepository<RefactorAccountRole, Long> {
}
