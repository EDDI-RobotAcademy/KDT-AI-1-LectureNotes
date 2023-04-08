package game.rpg.interfaceTest.character;

import game.rpg.interfaceTest.Skill;
import utility.random.CustomRandom;

// 만들어 놓은 interface를 사용할 때 implements 인터페이스 이름
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
    final int HP_MAX = 100;
    final int DEATH = -777;

    public GameCharacter() {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
        this.hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);
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

    // interface를 implements했다면
    // interface에 있는 껍데기 매서드들은 반드시 직접적으로 구현해줘야 합니다.

    // Object는 모든 타입을 수용할 수 있습니다.
    @Override
    public void firstSkill(Object target) {
        System.out.println("스킬명: 흑염룡의 손톱");

        final int damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);
        int targetHp = ((Monster) target).getHp();
        ((Monster) target).setHp(targetHp - damage);

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
                '}' + '\n';
    }
}
