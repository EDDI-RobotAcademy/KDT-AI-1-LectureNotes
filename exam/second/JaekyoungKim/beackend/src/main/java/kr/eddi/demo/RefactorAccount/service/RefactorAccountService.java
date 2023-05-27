package kr.eddi.demo.RefactorAccount.service;

import kr.eddi.demo.RefactorAccount.entity.RoleType;
import kr.eddi.demo.RefactorAccount.service.request.AccountRegisterRequest;
import kr.eddi.demo.RefactorAccount.service.request.RequestAccountLoginRequest;

public interface RefactorAccountService {
    Boolean refactorRegister(AccountRegisterRequest accountRegisterRequest);

    String login(RequestAccountLoginRequest accountLoginRequest);

    RoleType lookup(String userToken);
}
