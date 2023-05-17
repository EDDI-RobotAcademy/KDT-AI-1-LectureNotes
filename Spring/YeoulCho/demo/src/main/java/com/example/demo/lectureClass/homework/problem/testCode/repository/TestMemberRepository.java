package com.example.demo.lectureClass.homework.problem.testCode.repository;

import com.example.demo.lectureClass.homework.problem.testCode.entity.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestMemberRepository extends JpaRepository<TestMember,Long> {
    Optional<TestMember> findByMemberEmail(String memberEmail);
}
