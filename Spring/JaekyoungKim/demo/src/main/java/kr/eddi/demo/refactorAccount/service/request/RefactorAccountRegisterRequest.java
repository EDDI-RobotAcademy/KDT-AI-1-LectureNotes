package kr.eddi.demo.refactorAccount.service.request;


import kr.eddi.demo.refactorAccount.entity.RefactorAccount;
import kr.eddi.demo.refactorAccount.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefactorAccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public RefactorAccount toRefactorAccount () {

        return new RefactorAccount(email, password);
    }
}