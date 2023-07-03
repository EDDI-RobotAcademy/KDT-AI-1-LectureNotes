package kr.eddi.demo.account.controller.form;


import kr.eddi.demo.account.service.accountRegisterRequest.AccountRegisterRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
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