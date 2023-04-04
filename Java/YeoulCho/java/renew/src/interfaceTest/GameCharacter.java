package interfaceTest;

import utility.random.CustomRandom;

public class GameCharacter implements Skill{
    float strength;    //완력
    float intelligent; //지능
    float dexterity;   //재주
    float agility;     //민첩

    final int START = 10;
    final int END =20;

    public GameCharacter() {
        this.strength = CustomRandom.generateNumber(START,END);
        this.intelligent = CustomRandom.generateNumber(START,END);
        this.dexterity = CustomRandom.generateNumber(START,END);
        this.agility = CustomRandom.generateNumber(START,END);
    }

    //interface를 implements 했다면
    //interface에 있는 껍데기 메서드들을 반드시 직접적으로 구현해줘야합니다.
    @Override
    public float firstSkill() {
        return strength * 2.3f +dexterity *0.6f + agility*1.3f;

    }

    @Override
    public void secondSkill() { //아무것도 없어도 일단 만들기

    }
}
