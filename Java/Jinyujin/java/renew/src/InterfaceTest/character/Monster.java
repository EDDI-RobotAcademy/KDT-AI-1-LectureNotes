package InterfaceTest.character;

import InterfaceTest.Skill;
import utility.random.CustomRandom;

public class Monster implements Skill {
    int strength;    // 완력
    int intelligent; // 지능
    int dexterity;   // 재주
    int agility;     // 민첩
    int hp;
    int status; // 캐릭터의 상태, 아픈 상태, 죽은 상태 등 나타내기 위함

    final int START = 20;
    final int END = 30; // 몬스터는 여럿이서 때려 잡으니까 조금 더 높게
    final int HP_MIN = 200;
    final int HP_MAX = 300;
    public final int DEATH = -777; // 죽음 판정에 사용하기 위해 public 추가

    public Monster() {
        this.strength = CustomRandom.generateNumber(START,END);
        this.intelligent = CustomRandom.generateNumber(START,END);
        this.dexterity = CustomRandom.generateNumber(START,END);
        this.agility = CustomRandom.generateNumber(START,END);
        this.hp = CustomRandom.generateNumber(HP_MIN,HP_MAX);
    } // 캐릭터는 100명 정도 스킬 만들 때 구별을 해주어야 -> 인터페이스 활용

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public void firstskill(Object target) { // 스킬 쓰려면 타겟을 받아와야
        // 몬스터가 지가 지를 패거나 지 편을 패는 매개변수 Monster target -> targetIndex를 가져오도록 바꿔주어야 함
        System.out.println("스킬명: 돌진");

        final int damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);
        int targetHp = ((GameCharacter)target).getHp();
        ((GameCharacter)target).setHp(targetHp - damage);
    }

    @Override
    public void secondskill() {

    }

    @Override
    public String toString() {
        return "Monster{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                '}' +'\n'; // 엔터임
    }
}
