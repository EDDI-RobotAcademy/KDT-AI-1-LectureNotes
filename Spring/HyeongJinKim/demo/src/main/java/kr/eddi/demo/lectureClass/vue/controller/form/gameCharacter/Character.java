package kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Character {

    private Boolean gender;
    private int characterId;

    private int strength;
    private int dexterity;
    private int intelligence;
}