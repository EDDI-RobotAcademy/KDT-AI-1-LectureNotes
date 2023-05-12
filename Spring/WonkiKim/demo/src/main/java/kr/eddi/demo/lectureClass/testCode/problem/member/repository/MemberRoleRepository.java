package kr.eddi.demo.lectureClass.testCode.problem.member.repository;

import kr.eddi.demo.lectureClass.testCode.problem.member.entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {
}
