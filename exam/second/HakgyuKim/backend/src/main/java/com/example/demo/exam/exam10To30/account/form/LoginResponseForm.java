package com.example.demo.exam.exam10To30.account.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseForm {
    private Long accountId;

    public LoginResponseForm(Long accountId) {
        this.accountId = accountId;
    }
}
