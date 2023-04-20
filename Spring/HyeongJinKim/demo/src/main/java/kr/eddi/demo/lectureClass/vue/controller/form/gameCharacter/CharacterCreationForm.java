package kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterCreationForm {

    private Boolean gender;
    private int characterId;

    private int strength;
    private int dexterity;
    private int intelligence;

    public Character toCharacter(Boolean gender, int characterId) {
        return new Character(
                gender, characterId, strength, dexterity, intelligence
        );
    }
}