package interfaceTest;

import utilityRandom.CustomRandom;

public class GameCharacter implements Skill {
    int strength;   //완력
    int intelligent;//능지
    int dexterity;  //재주
    int agility;    //민첩

    final int START=10;
    final int END=20;


    public GameCharacter() {
        this.strength = CustomRandom.generateNumber(START,END);
        this.intelligent =CustomRandom.generateNumber(START,END);
        this.dexterity = CustomRandom.generateNumber(START,END);
        this.agility = CustomRandom.generateNumber(START,END);
    }
    // interface를 implements 했다면
    // interface의 메서드를 반드시 직접적으로 구현해야 합니다.
    @Override
    public float firstSkill() {
        return strength*2.3f+dexterity*0.6f+agility*1.3f;

    }

    @Override
    public void secondSkill() {

    }
}
