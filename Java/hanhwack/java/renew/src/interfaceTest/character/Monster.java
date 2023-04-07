package interfaceTest.character;

import interfaceTest.Skill;
import utility.random.CustomRandom;

public class Monster implements Skill {
    int strength ;
    int intelligent ;
    int dexterity ;  // 손재주
    int agility ; // 민첩
    int hp ;

    final int START = 20 ;
    final int END = 30 ;
    final int HP_MIN = 100;
    final int HP_MAX = 200;

    public Monster() {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
        this.hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);
    }

    public float firstSkill() {
        return 0;
    }

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
