package com.example.demo.exam.exam10To30.account.repository;

import com.example.demo.exam.exam10To30.account.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query("select ar from AccountRole ar where ar.account.id = :accountId")
    AccountRole findByAccountId(Long accountId);
}
