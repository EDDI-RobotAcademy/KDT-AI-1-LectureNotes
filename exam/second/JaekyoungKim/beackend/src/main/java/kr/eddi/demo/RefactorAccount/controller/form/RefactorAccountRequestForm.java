package kr.eddi.demo.RefactorAccount.controller.form;

import kr.eddi.demo.RefactorAccount.entity.RoleType;
import kr.eddi.demo.RefactorAccount.service.request.AccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RefactorAccountRequestForm {
   final private String email;
   final private String password;

   final private RoleType roleType;

    public AccountRegisterRequest toAccountRegisterRequest () {

        return new AccountRegisterRequest(
                email, password, roleType);
    }
}
