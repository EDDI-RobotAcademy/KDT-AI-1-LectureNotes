package com.example.demo.lectureClass.vue.homework.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SelectAccountForm {
    private int accountId;

    public SelectAccountForm(int accountId) {
        this.accountId = accountId;
    }
}