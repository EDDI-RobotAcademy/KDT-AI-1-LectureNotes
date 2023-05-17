package com.example.demo.lectureClass.vue.homework.charactergame;

import com.example.demo.lectureClass.untility.random.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CharacterStatus {
    private int strength;       // 완력
    private int intelligent;    // 지능
    private int dexterity;      // 재주
    private int agility;        // 민첩
    private int hp;             // hp
    int[] characterStatus;
    final int CHARACTER_HP_MIN = 100;
    final int CHARACTER_HP_MAX = 200;
    final int CHARACTER_STAT_MIN = 15;
    final int CHARACTER_STAT_MAX = 20;

    private int accountId;
    private int currentCharacterId;

    public CharacterStatus(int id, int characterId) {

        strength = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        intelligent = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        dexterity = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        agility = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        hp = CustomRandom.generateNumber(CHARACTER_HP_MIN,CHARACTER_HP_MAX);

        this.accountId = id;
        this.currentCharacterId = characterId;

        characterStatus = new int[] {currentCharacterId, strength, intelligent, dexterity, agility, hp};
    }

    public int[] getCharacterStatus() {
        return characterStatus;
    }
}
