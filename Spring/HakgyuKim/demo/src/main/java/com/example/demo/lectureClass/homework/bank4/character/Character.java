package com.example.demo.lectureClass.homework.bank4.character;

import com.example.demo.lectureClass.utility.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Character {
    final private String email;
    final private String password;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int skill;

    final private int HEALTH_MIN = 50;
    final private int HEALTH_MAX = 100;
    final private int STATUS_MIN = 2;
    final private int STATUS_MAX = 10;

    public Character(String email, String password) {
        this.email = email;
        this.password = password;
        this.health = CustomRandom.generateNumber(HEALTH_MIN, HEALTH_MAX);
        this.strength = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.dexterity = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.intelligence = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.skill = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
    }

}
