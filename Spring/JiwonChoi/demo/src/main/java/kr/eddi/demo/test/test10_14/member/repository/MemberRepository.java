package kr.eddi.demo.test.test10_14.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
