package kr.eddi.demo.lectureClass.testCode.problem.repository;


import kr.eddi.demo.lectureClass.testCode.problem.entity.Member1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Member1Repository extends JpaRepository<Member1, Long> {
    Optional<Member1> findByAccountId(String accountId);
}
