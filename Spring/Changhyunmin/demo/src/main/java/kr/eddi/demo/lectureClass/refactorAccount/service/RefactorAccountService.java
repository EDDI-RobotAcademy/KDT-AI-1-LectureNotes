package kr.eddi.demo.lectureClass.refactorAccount.service;

import kr.eddi.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import kr.eddi.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;

public interface RefactorAccountService {
    Boolean register(RefactorAccountRegisterRequest request);
}
