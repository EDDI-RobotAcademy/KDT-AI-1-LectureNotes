package kr.eddi.demo.RefactorAccount.service.request;

import kr.eddi.demo.RefactorAccount.entity.RefactorAccount;
import kr.eddi.demo.RefactorAccount.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AccountRegisterRequest {
    final private String email;
    final private String password;
    final private RoleType roleType;

    public RefactorAccount toAccount () {
        return new RefactorAccount(email, password);
    }
}
