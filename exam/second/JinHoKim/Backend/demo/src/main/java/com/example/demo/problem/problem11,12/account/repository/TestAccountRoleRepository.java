package com.example.demo.problem.problem11.account.repository;

import com.example.demo.problem.problem11.account.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestAccountRoleRepository extends JpaRepository<AccountRole, Long> {
    List<AccountRole> findAllByRole(String role);
}