package interfaceTest.character;

import interfaceTest.Skill;
import utility.random.CustomRandom;

public class Monster implements Skill {
    int strength;    //완력
    int intelligent; //지능
    int dexterity;   //재주
    int agility;     //민첩
    int hp;
    int status;
    final int HP_MIN =200;
    final int HP_MAX =300;

    final int START = 20;
    final int END =30;

    final public int DEATH = -777;

    public Monster() {
        this.strength = CustomRandom.generateNumber(START,END);
        this.intelligent = CustomRandom.generateNumber(START,END);
        this.dexterity = CustomRandom.generateNumber(START,END);
        this.agility = CustomRandom.generateNumber(START,END);
        this.hp = CustomRandom.generateNumber(HP_MIN,HP_MAX);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void firstSkill(Object target) {
        System.out.println("스킬명: 돌진");

        final int damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);
        int targetHp = ((GameCharacter)target).getHp();
        ((GameCharacter)target).setHp(targetHp - damage);
    }

    @Override
    public void secondSkill() {

    }

    @Override
    public String toString() {
        return "Monster{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                '}' + '\n';
    }
}
