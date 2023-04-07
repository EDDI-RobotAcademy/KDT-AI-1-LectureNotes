package interfacePractice.character;

import interfacePractice.Skill;
import utility.Random;

public class GameCharacter implements Skill {
    int strength;
    int intelligent;
    int dexterity;
    int agility;
    int hp;
    int status;

    final int START = 10;
    final int END = 20;
    final int HP_MIN = 70;
    final int HP_MAX = 150;
    final int DEATH = -777;

    public GameCharacter() {
        this.strength = Random.generateNumber(START, END);
        this.intelligent = Random.generateNumber(START, END);
        this.dexterity = Random.generateNumber(START, END);
        this.agility = Random.generateNumber(START, END);
        this.hp = Random.generateNumber(HP_MIN, HP_MAX);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public void firstSkill(Object target) {
        System.out.println("스킬명: 흑염룡의 손톱");

        final int damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);
        int targetHp = ((Monster) target).getHp();
        ((Monster) target).setHp(targetHp - damage);
    }

    @Override
    public void secondSkill() {

    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                '}' + '\n';
    }
}
