package interfaceTest;

import random.CustomRandom;

public class GameCharter implements Skill {
    int strength; //완력
    int intelligent; //지능
    int dexterity; //재주
    int agility; //민첩
    final int Start = 10;
    final int End = 20;

    public GameCharter() {
        this.strength = CustomRandom.generateNumber(Start, End);
        this.intelligent = CustomRandom.generateNumber(Start, End);
        this.dexterity = CustomRandom.generateNumber(Start, End);
        this.agility = CustomRandom.generateNumber(Start, End);
    }
    //interface를 implements 했다면
    //interface에 있는 껍데기 메서드들을 반드시 직접적으로 구현해 줘야합니다.
    @Override
    public float first_Skill() {
        return strength * 2.3f + dexterity * 0.6f + agility * 1.3f;
    }

    @Override
    public void second_Skill() {

    }
}
