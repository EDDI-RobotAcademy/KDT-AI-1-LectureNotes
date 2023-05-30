package kr.eddi.demo.lectureClass.account.controller.form;

import kr.eddi.demo.lectureClass.account.service.request.AccountRegisterRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class AccountRegisterForm {
    private String email;

    public AccountRegisterForm(String email) {
        this.email = email;
    }

    public AccountRegisterRequest toAccountRegisterRequest() {
        return new AccountRegisterRequest(email);
    }
}
