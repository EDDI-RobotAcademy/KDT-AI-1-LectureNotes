package review.rpgGame;

import InterfaceTest.character.Monster;
import utility.random.CustomRandom;

public class GameCharacter implements Skill {
    // 게임 캐릭터의 능력치들 선언
    int strength;    // 힘
    int intelligent; // 지능
    int dexterity;   // 재주
    int agility;     // 민첩함
    int hp;
    int status; // 캐릭터의 상태 - 아픈 상태, 죽은 상태 나타내기 위함

    public void setStatus(int status) {
        this.status = status;
    } // 죽었을 때의 상태를 나타내기 위해

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // 이 능력치들에 대한 선언
    final int START = 10;
    final int END = 20;
    final int HP_MIN = 70;
    final int HP_MAX = 150; // hp는 캐릭터 쪽수가 더 많으니까 더 적게
    final int DEATH = -999;

    public GameCharacter () {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
        this.hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);
    } // 캐릭터가 무수히 많을 것임
    // 그 캐릭터들에 대해 스킬을 일일이 선언해주기 힘들 것임
    // -> 스킬 인터페이스 활용 (캐릭터들이 사용하는 스킬이 같기 때문에)

    // 두 스킬에 대한 메소드는 인터페이스에서 생성되었기 때문에
    // 사용하지 않더라도 만들어 두어야 한다 (현재 secondSkill처럼)
    @Override
    public void firstSkill(Object target) { // 타겟 스킬이기에 타겟에 대한 변수를 매개변수로
                                            // 즉 스킬쓰려면 타겟 받아오라는 뜻
        // firstSkill은 타겟팅해서 공격하는 스킬
        System.out.println("스킬명: 흑염룡의 손톱");
        // 이 스킬이 데미지를 얼마나 입히는지
        final int damage = (int) (strength * 2.3f + dexterity * 0.6f + agility * 1.3f);

        // 이 스킬을 실행했을 때 타켓 몬스터의 hp를 보여주는 코드
        int targetHp = ((Monster)target).getHp();
        ((Monster)target).setHp(targetHp - damage);
        // 몬스터 hp 까이는 것 보여줌
        // 몬스터 클래스에서 타겟 하나의 hp를 꺼내와서 targetHp라는 이름으로 저장한 후
        // 그 몬스터 클래스의 타겟의 hp를 (targetHp - damage)로 설정한다

        // 여기까지 아직 몬스터가 죽이는 건 표현 안함 - 죽어서도 때릴 수 있다는 결과 나옴
        // 몬스터가 공격할 때 -> 게임캐릭터를 타겟으로 하도록
    }

    @Override
    public void secondSkill() {
        // 광역 스킬
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
                '}' + '\n'; // 이거 엔터라는 뜻임
    }
}


















