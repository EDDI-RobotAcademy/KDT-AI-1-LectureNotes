package com.example.demo.exam.refactorAccount.repository;

import com.example.demo.exam.refactorAccount.entity.RefactorAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefactorAccountRoleRepository extends JpaRepository<RefactorAccountRole, Long> {
}
