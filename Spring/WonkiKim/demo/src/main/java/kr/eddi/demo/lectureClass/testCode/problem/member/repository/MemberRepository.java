package kr.eddi.demo.lectureClass.testCode.problem.member.repository;


import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String Email);
}
