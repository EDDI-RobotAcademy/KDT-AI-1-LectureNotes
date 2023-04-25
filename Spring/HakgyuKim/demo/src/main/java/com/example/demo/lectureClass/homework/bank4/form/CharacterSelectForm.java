package com.example.demo.lectureClass.homework.bank4.form;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class CharacterSelectForm {
    final private int accountId;
    final private int selectedCharacterIdx;
}
