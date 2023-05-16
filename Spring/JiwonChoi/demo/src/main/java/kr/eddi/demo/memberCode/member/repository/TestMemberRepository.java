package kr.eddi.demo.memberCode.member.repository;

import kr.eddi.demo.memberCode.member.entity.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestMemberRepository extends JpaRepository<TestMember, String> {
    Optional<TestMember> findByName(String name);
}
