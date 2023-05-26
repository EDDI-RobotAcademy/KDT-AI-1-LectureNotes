package kr.eddi.demo.RefactorAccount.repository;

import kr.eddi.demo.RefactorAccount.entity.RefactorAccount;
import kr.eddi.demo.RefactorAccount.entity.RefactorAccountRole;
import kr.eddi.demo.RefactorAccount.entity.RefactorRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RefactorAccountRoleRepository extends JpaRepository<RefactorAccountRole,Long> {
    @Query("select rar.role from RefactorAccountRole ar join fetch RefactorRole rr where rar.account = :account")
    RefactorRole findByInfoByAccount(RefactorAccount account);
}
