package review.rpgGame;

import utility.random.CustomRandom;

public class Monster implements Skill { // 몬스터도 게임캐릭터랑 비슷하게
    // 몬스터도 결국 캐릭터니까
    int strength;    // 힘
    int intelligent; // 지능
    int dexterity;   // 재주
    int agility;     // 민첩함
    int hp;
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // 이 능력치들에 대한 선언
    final int START = 20;
    final int END = 30;
    final int HP_MIN = 200;
    final int HP_MAX = 300;
    public final int DEATH = -999; // 죽음 판정에 사용하기 위해 public 추가

    public Monster() {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
        this.hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);
    }

    @Override
    public void firstSkill(Object target) {
        // 처음에 매개변수 Monster target 이었는데 타입을 Object로 바꿈
        // 몬스터가 지가 지를 패거나 지 편을 패는 매개변수 Monster target
        // -> targetIndex를 가져오도록 바꿔주어야 함
        System.out.println("스킬명: 돌진");

        // 마찬가지로 이 스킬에 맞았을 때 데미지 보여주기
        final int damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);
        // 이 스킬을 실행했을 때 타켓 게임캐릭터의 hp를 보여주는 코드
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
