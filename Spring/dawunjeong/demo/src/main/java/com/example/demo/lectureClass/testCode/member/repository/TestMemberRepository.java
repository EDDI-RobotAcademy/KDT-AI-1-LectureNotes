package com.example.demo.lectureClass.testCode.member.repository;

import com.example.demo.lectureClass.testCode.member.entity.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestMemberRepository extends JpaRepository<TestMember, Long> {
    Optional<TestMember> findByEmail(String email);
}
