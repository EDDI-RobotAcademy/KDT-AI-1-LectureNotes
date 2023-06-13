package com.example.demo.test.q10_14.member.repository;
import com.example.demo.test.q10_14.member.entity.BusinessMember;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BusinessMemberRepository extends JpaRepository<BusinessMember, Long> {
}