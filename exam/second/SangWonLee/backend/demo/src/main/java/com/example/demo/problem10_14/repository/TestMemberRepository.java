package com.example.demo.problem10_14.repository;

import com.example.demo.problem10_14.entity.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestMemberRepository extends JpaRepository<TestMember, Long> {
    Optional<TestMember> findByEmail(String email);
}
