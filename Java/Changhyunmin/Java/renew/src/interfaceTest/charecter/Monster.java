package interfaceTest.charecter;

import interfaceTest.controller.Skill;
import random.CustomRandom;

public class Monster implements Skill {
    int strength; //완력
    int intelligent; //지능
    int dexterity; //재주
    int agility; //민첩
    int HP;
    int Status;
    final int Start = 20;
    final int End = 30;
    int HP_MIN = 200;
    int HP_MAX = 300;
    public final int DEATH = -777;




    public Monster() {
        this.strength = CustomRandom.generateNumber(Start, End);
        this.intelligent = CustomRandom.generateNumber(Start, End);
        this.dexterity = CustomRandom.generateNumber(Start, End);
        this.agility = CustomRandom.generateNumber(Start, End);
        this.HP = CustomRandom.generateNumber(HP_MIN, HP_MAX);
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStatus() {
        return Status;
    }
    public void setStatus(int status) {
        this.Status = status;
    }


    @Override
    public void first_Skill(Object target) {
        System.out.println("스킬명: 돌진");
        final int damage = (int) (strength * 2.3f + dexterity * 0.6f
        + agility * 1.3f);
        int targetHP = ((GameCharacter)target).getHP();
        ((GameCharacter)target).setHP(targetHP - damage);

    }

    @Override
    public void second_Skill() {


    }

    @Override
    public String toString() {
        return "Monster{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", HP=" + HP +
                '}' + '\n';
    }
}
