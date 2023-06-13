package kr.eddi.demo.lectureClass.testCode.member.repository;

import kr.eddi.demo.lectureClass.testCode.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.student.entity.TestStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByMemberName(String name);
}
