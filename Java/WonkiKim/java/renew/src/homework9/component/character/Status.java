package homework9.component.character;

import utility.random.CustomRandom;

public class Status {
    final private int strength;
    final private int agility;
    final private int ability;
    final private int intellect;
    private int hp;
    private int mp;

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getAbility() {
        return ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public Status() {
        strength = CustomRandom.generateNumber(4, 8);
        agility = CustomRandom.generateNumber(4, 8);
        ability = CustomRandom.generateNumber(4, 8);
        intellect = CustomRandom.generateNumber(4, 8);
        hp = 100;
        mp = 100;
    }

    public void decreaseMp(int mpPoint) {
        mp -= mpPoint;
    }

    public void decreaseHp(int hpPoint) {
        hp -= hpPoint;
    }
}
