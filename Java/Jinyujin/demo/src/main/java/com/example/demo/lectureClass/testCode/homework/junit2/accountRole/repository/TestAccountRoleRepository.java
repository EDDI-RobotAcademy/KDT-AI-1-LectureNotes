package com.example.demo.lectureClass.testCode.homework.junit2.accountRole.repository;

import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TestAccountRoleRepository extends JpaRepository<AccountRole, Long> {

    //@Query("select to from TestAccount to where to.AccountRole.role = :role")
    Optional<AccountRole> findByRole(String role);
}
