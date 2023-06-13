package com.example.springPart.account.controller.form;

import com.example.springPart.account.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SignUpRequestForm {
    @Getter
    final private String email;
    final private String password;
    final private String role;
    final private String businessNumber;

    public Account toAccount() {
        if(this.businessNumber==null) {
            return new Account(this.email, this.password, this.role, null);
        }
        return new Account(this.email, this.password, this.role, this.businessNumber);
    }
}
