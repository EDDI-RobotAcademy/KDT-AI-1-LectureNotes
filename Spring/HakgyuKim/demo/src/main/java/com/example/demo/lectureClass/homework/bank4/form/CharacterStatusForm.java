package com.example.demo.lectureClass.homework.bank4.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class CharacterStatusForm {
    final private String email;
    final private String characterName;
    final private int health;
    final private int strength;
    final private int dexterity;
    final private int intelligence;
    final private int skill;
    final private int characterIdx;
}
