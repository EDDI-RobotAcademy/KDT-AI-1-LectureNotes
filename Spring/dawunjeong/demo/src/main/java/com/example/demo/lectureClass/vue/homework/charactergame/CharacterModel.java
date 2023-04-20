package com.example.demo.lectureClass.vue.homework.charactergame;

import com.example.demo.lectureClass.untility.random.CustomRandom;
import lombok.ToString;

@ToString
public class CharacterModel {
    private int strength;       // 완력
    private int intelligent;    // 지능
    private int dexterity;      // 재주
    private int agility;        // 민첩
    private int hp;             // hp
    int[] characterStatus = new int[5];
    final int CHARACTER_HP_MIN = 100;
    final int CHARACTER_HP_MAX = 200;
    final int CHARACTER_STAT_MIN = 15;
    final int CHARACTER_STAT_MAX = 20;

    public CharacterModel() {

        strength = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        intelligent = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        dexterity = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        agility = CustomRandom.generateNumber(CHARACTER_STAT_MIN,CHARACTER_STAT_MAX);
        hp = CustomRandom.generateNumber(CHARACTER_HP_MIN,CHARACTER_HP_MAX);

        characterStatus[0] = strength;
        characterStatus[1] = intelligent;
        characterStatus[2] = dexterity;
        characterStatus[3] = agility;
        characterStatus[4] = hp;
    }

    public int[] getCharacterStatus() {
        return characterStatus;
    }

}
