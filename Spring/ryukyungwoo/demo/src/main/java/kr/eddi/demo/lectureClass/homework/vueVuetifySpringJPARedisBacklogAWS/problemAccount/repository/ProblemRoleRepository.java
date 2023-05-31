package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.repository;

import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemRole;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProblemRoleRepository extends JpaRepository<ProblemRole, Long> {
    Optional<ProblemRole> findByRoleType(ProblemRoleType roleType);
}
