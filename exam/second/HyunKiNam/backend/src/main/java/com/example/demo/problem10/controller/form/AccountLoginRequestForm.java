package com.example.demo.problem10.controller.form;

import com.example.demo.problem10.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountLoginRequestForm {

    private String email;
    private String password;

    public AccountLoginRequestForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account toAccount(){
        return new Account(email, password);
    }
}
