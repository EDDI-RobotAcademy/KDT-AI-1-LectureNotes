package interfaceTest.charecter;

import interfaceTest.controller.Skill;
import random.CustomRandom;

public class GameCharacter implements Skill {
    int strength; //완력
    int intelligent; //지능
    int dexterity; //재주
    int agility; //민첩
    int HP;
    int Status;
    final int Start = 10;
    final int End = 20;
    int HP_MIN = 100;
    int HP_MAX = 200;
    final int DEATH = -777;

    public GameCharacter() {
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

    public void setStatus(int status) {
        this.Status = status;
    }

    //interface를 implements 했다면
    //interface에 있는 껍데기 메서드들을 반드시 직접적으로 구현해 줘야합니다.
    @Override
    public void first_Skill(Object target) {
        System.out.println("스킬명: 흑염룡의 손톱");

        final int Damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);
        int targetHP = ((Monster)target).getHP();
        ((Monster)target).setHP(targetHP-Damage);
    }
    @Override
    public void second_Skill() {
        System.out.println("스킬명: 흑염룡의 포효");

    }
    @Override
    public String toString() {
        return "GameCharter{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", HP=" + HP +
                '}' + '\n';
    }
}
