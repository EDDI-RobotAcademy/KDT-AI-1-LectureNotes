package com.example.demo.lectureClass.testCode.homework.junit1.repository;

import com.example.demo.lectureClass.testCode.homework.junit1.entity.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestMemberRepository extends JpaRepository<TestMember, Long> {
    Optional<TestMember> findByName(String name);
}
