package kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service.form;

import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.entity.AuthAccount;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountRegisterRequest {
    final private String email;

    public AuthAccount toAccount() {
        return new AuthAccount(this.email);
    }

}
