package com.example.demo.problem.repository;

import com.example.demo.problem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.management.relation.Role;

public interface AccountRoleRepository extends JpaRepository<Account, Long> {

    @Query("select ar.role from AccountRole ar join fehch r where ar .account = :account")
    Role findRoleInfoByAccount(Account account);
}
