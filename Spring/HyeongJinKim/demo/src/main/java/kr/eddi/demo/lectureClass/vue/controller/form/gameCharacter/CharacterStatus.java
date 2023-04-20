package kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CharacterStatus {

    private Boolean gender;
    private int characterId;

    private int strength;
    private int dexterity;
    private int intelligence;

    public CharacterStatus(Boolean gender, int characterId) {
        final int STATUS_MIN = 1;
        final int STATUS_MAX = 10;

        this.gender = gender;
        this.characterId = characterId;

        this.strength = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.dexterity = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.intelligence = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
    }
}
