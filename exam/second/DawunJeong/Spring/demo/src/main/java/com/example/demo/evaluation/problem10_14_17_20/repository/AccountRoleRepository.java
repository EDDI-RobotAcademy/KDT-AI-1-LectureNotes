package com.example.demo.evaluation.problem10_14_17_20.repository;

import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query("select ar from AccountRole ar join fetch ar.role where ar.account = :maybeAccount")
    Optional<AccountRole> findByAccount(Optional<Account> maybeAccount);
}
