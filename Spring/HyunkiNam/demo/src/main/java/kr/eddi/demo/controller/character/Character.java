package kr.eddi.demo.controller.character;

import kr.eddi.demo.lectureClass.vue.controller.utility.random.CustomRandom;

public class Character {

    final int STATUS_MIN = 5;
    final int STATUS_MAX = 15;

    final String user_email;
    final String user_password;
    final int strength;
    final int dexterity;
    final int intellect;

    public Character(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.strength = CustomRandom.generateNumber(STATUS_MIN,STATUS_MAX);
        this.dexterity = CustomRandom.generateNumber(STATUS_MIN,STATUS_MAX);
        this.intellect = CustomRandom.generateNumber(STATUS_MIN,STATUS_MAX);
    }

    public String getUser_email() {
        return user_email;
    }

    @Override
    public String toString() {
        return "Character{" +
                "user_email='" + user_email + '\'' +
                '}';
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntellect() {
        return intellect;
    }
}
