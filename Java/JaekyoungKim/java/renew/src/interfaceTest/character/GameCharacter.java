package interfaceTest.character;

import interfaceTest.Skill;
import utility.random.CustomRandom;


public class GameCharacter implements Skill {
    int strength;   //완력
    int intelligent;//능지
    int dexterity;  //재주
    int agility;    //민첩
    int hp;

    int status;

    public void setStatus(int status) {
        this.status = status;
    }

    final int DEATH=-777;
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }



    final int HP_MIN=70;
    final int HP_MAX=150;

    final int START=10;
    final int END=20;


    public GameCharacter() {
        this.strength = CustomRandom.generateNumber(START,END);
        this.intelligent =CustomRandom.generateNumber(START,END);
        this.dexterity = CustomRandom.generateNumber(START,END);
        this.agility = CustomRandom.generateNumber(START,END);
        this.hp = CustomRandom.generateNumber(HP_MIN,HP_MAX);
    }
    // interface를 implements 했다면
    // interface의 메서드를 반드시 직접적으로 구현해야 합니다.
    @Override
    public void firstSkill(Object target){
        System.out.println("스킬명: 무자비한 일격");
        final int damage = (int)(strength * 2.3 + dexterity * 0.6 + agility * 1.3);
        int targetHp=((Monster)target).getHP();
        ((Monster)target).setHp(targetHp-damage);
    }

    @Override
    public void secondSkill() {
        System.out.println("스킬명: 흑염룡의 포효");

    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                '}'+'\n';
    }


}
