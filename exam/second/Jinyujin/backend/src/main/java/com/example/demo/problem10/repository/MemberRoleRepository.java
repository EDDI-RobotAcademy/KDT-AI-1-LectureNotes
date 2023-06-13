package com.example.demo.problem10.repository;

import com.example.demo.problem10.entity.Member;
import com.example.demo.problem10.entity.MemberRole;
import com.example.demo.problem10.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {
    MemberRole findByMember(Member member);

    Optional<MemberRole> findByRole(RoleType roleType);
}
