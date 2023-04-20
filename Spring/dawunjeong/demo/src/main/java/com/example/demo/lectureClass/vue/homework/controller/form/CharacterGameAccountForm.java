package com.example.demo.lectureClass.vue.homework.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterGameAccountForm {
    final private String email;
    final private String password;
}
