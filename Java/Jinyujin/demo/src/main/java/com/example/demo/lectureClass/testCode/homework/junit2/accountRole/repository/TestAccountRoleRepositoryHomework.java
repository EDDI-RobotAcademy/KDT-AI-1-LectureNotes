package com.example.demo.lectureClass.testCode.homework.junit2.accountRole.repository;

import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRoleHomework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAccountRoleRepositoryHomework extends JpaRepository<AccountRoleHomework, Long> {

    //@Query("select to from TestAccount to where to.AccountRole.role = :role")
    Optional<AccountRoleHomework> findByRole(String role);
}
