package com.example.demo.problem10.repository;

import com.example.demo.problem10.entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<MemberRole, Long> {
}
