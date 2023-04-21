package com.example.demo.lectureClass.vue.homework.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class FindAccountForm {
    private int accountId;

    public FindAccountForm(int accountId) {
        this.accountId = accountId;
    }
}