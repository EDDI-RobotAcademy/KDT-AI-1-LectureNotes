package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.controller.form;

import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemRoleType;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service.request.ProblemAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProblemAccountRegisterRequestForm {
    final private String email;
    final private String password;
    final private ProblemRoleType roleType;

    public ProblemAccountRegisterRequest toRefactorAccountRegisterRequest () {

        return new ProblemAccountRegisterRequest(
                email, password, roleType);
    }
}
