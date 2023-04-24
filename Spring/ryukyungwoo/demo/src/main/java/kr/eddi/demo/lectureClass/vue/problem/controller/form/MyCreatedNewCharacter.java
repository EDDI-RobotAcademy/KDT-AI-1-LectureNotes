package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;

import java.util.List;


public class MyCreatedNewCharacter {
    final private String email;
    final private String pasword;
    final private int strength;
    final private int dexterity;
    final private int intelligence;
    final private int luck;

    public MyCreatedNewCharacter (String email, String password) {
        this.email = email;
        this.pasword = password;

        strength = CustomRandom.generateNumber(10, 20);
        dexterity = CustomRandom.generateNumber(10, 20);
        intelligence = CustomRandom.generateNumber(10, 20);
        luck = CustomRandom.generateNumber(10, 20);

    }

    public String getEmail() {
        return email;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getLuck() {
        return luck;
    }
}
