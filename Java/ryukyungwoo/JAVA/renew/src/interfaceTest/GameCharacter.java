package interfaceTest;

import utility.random.CustomRandom;
// 만들어 놓은 interface를 사용할 때 implements 인터페이스 이름
public class GameCharacter implements Skill {
    int strength;    // 완력
    int intelligent; // 지능
    int dexterity;   // 재주
    int agility;     // 민첩

    final int START = 10;
    final int END = 20;

    public GameCharacter() {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
    }

    // interface를 implements 했다면
    // interface에 있는 껍데기 매서드들을 반드시 직접적으로 구현해줘야 합니다.
    @Override
    public float first_skill() {
        return strength * 2.3f + dexterity * 0.6f + agility * 1.3f;
    }

    @Override
    public void second_skill() {
    }
}
