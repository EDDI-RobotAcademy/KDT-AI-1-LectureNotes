package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service.request;

import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemAccount;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemRoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProblemAccountRegisterRequest {
    final private String email;
    final private String password;
    final private ProblemRoleType roleType;

    public ProblemAccount toProblemAccount () {

        return new ProblemAccount(email, password);
    }
}
