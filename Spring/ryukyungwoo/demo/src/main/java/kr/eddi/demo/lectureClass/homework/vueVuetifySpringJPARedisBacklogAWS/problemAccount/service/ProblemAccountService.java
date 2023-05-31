package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service;

import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service.request.ProblemAccountRegisterRequest;

public interface ProblemAccountService {
    Boolean register(ProblemAccountRegisterRequest request);
}
