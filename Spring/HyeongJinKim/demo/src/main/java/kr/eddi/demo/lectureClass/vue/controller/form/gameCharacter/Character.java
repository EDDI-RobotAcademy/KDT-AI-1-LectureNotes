package kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Character {

    private String selectedGender;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int characterId;
    private int accountId;
}