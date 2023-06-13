package kr.jinho.jinhokim.testCode.fetchType.account.repository;

import kr.jinho.jinhokim.testCode.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {

    @Query("select ar from JpaAccountRole ar join fetch JpaAccount ja where ar.role = :role")
    List<JpaAccountRole> findAllByRole(String role);

}
