package kr.eddi.demo.lectureClass.refactorAccount.service.request;

import kr.eddi.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import kr.eddi.demo.lectureClass.refactorAccount.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefactorAccountRegisterRequest {
    private final String email;
    private final String password;
    private final RoleType roleType;

    public RefactorAccount toRefactorAccount () {
        return new RefactorAccount(email, password);
    }
}
