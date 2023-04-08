package interfaceTest.character;

import interfaceTest.Skill;
import utility.random.CustomRandom;

public class GameCharacter  implements Skill {
    int strength ;
    int intelligent ;
    int dexterity ;  // 손재주
    int agility ; // 민첩
    int hp ;

    final int START = 10 ;
    final int END = 20 ;
    final int HP_MIN = 70;
    final int HP_MAX = 150;

    public GameCharacter() {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
        this.hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);
    }

    // interface를 implements 했다면
    // interface에 있는 껍데기 매서드들을 반드시 직접적으로 구현해줘야 합니다.

    @Override
    public float firstSkill() {
        System.out.println("스킬명: 흑염룡의 손톱");
        return strength * 2.3f + dexterity * 0.6f + agility * 1.3f ;

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
