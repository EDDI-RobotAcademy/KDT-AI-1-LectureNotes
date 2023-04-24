package com.example.demo.lectureClass.homework.bank4.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class AccountSpecifyForm {

    private int accountId;

    public AccountSpecifyForm(int accountId) {
        this.accountId = accountId;
    }
}
