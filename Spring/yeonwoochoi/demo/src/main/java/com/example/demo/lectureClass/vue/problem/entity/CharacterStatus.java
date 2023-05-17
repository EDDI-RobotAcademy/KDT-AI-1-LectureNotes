package com.example.demo.lectureClass.vue.problem.entity;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CharacterStatus {

    private int strength;
    private int dexterity;
    private int vital;
    private int intelligence;

    private Long whosAccountId;

    public CharacterStatus(long id) {
        final int MIN = 10;
        final int MAX = 20;

        this.strength = CustomRandom.generateNumber(MIN, MAX);
        this.dexterity = CustomRandom.generateNumber(MIN, MAX);
        this.vital = CustomRandom.generateNumber(MIN, MAX);
        this.intelligence = CustomRandom.generateNumber(MIN, MAX);

        this.whosAccountId = id;
    }
}
