package com.example.demo.lectureClass.vue.homework.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CreateCharacterForm {
    private int accountId;

    public CreateCharacterForm(int accountId) {
        this.accountId = accountId;
    }
}
