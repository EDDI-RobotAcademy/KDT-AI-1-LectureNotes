package kr.eddi.demo.problem1319.Account.repository;

import kr.eddi.demo.problem1319.Account.entity.BusinessAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessAccountRoleRepository extends JpaRepository<BusinessAccountRole,Long> {
    Optional<BusinessAccountRole> findByAccountId(Long id);
}
