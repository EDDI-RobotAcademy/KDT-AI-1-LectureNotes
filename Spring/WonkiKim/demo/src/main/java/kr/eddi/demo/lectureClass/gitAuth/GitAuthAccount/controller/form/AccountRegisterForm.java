package kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.controller.form;

import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service.form.AccountRegisterRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRegisterForm {
    private String email;

    public AccountRegisterForm(String email) {
        this.email = email;
    }

    public AccountRegisterRequest toAccountRgisterRequest() {
        return new AccountRegisterRequest(email);
    }
}
