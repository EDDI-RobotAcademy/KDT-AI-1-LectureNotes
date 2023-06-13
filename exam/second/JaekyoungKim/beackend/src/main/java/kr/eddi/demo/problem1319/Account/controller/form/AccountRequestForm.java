package kr.eddi.demo.problem1319.Account.controller.form;

import kr.eddi.demo.problem1319.Account.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequestForm {

    final private String email;
    final private String password;

    public Account toAccount(){
        return new Account(email,password);
    }
}
