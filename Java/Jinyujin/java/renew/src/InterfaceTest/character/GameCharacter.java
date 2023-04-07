package InterfaceTest.character;

import InterfaceTest.Skill;
import utility.random.CustomRandom;

// 만들어 놓은 interface를 사용할 때 implements 인터페이스이름
public class GameCharacter implements Skill { // 하고 Alt+enter 하면 생성완료 (Alt+insert 해도 됨)
    // 임플리먼츠 하고 나면 껍데기 만들어 놓은 것 구현해줘야 함
    int strength;    // 완력
    int intelligent; // 지능
    int dexterity;   // 재주
    int agility;     // 민첩
    int hp;
    int status; // 캐릭터의 상태, 아픈 상태, 죽은 상태 등 나타내기 위함

    final int START = 10;
    final int END = 20;
    final int HP_MIN = 70;
    final int HP_MAX = 150; // 쪽수 많으니까 몬스터보다 좀 더 적게
    final int DEATH = -777;


    public GameCharacter() {
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
    } // 죽었을 때의 상태를 나타내기 위해

    // interface를 implements 했다면
    // interface에 있는 껍데기 메서드들을 반드시 직접적으로 구현해줘야 합니다
    // 세컨드 스킬처럼 아무것도 안해도 메서드가 만들어져 있어야 한다
    @Override
    public void firstskill(Object target) { // Object는 모든 타입을 수용할 수 있습니다
        // 모든 타입을 다 수용한다는 뜻 (int target으로 하려했더니 리스트 끌고와야 하는 문제 발생했음)
        // int, float, Monster, GameCharacter, String 뭐가 되었든 전부 수용 가능
        System.out.println("스킬명: 흑염룡의 손톱");

        final int damage = (int)( strength + 2.3f + dexterity * 0.6f + agility * 1.3f); // 타겟 인덱스에 이 데미지를 갖다 박겠다
        int targetHp = ((Monster)target).getHp();
        ((Monster) target).setHp(targetHp - damage); // 몬스터 hp 까이는 것 보여줌
        // 여기까지 아직 몬스터가 죽이는 건 표현 안함 - 죽어서도 때릴 수 있다는 결과 나옴
        // 몬스터가 공격할 때 -> 게임캐릭터를 타겟으로 하도록
    }

    @Override
    public void secondskill() {
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
                '}' +'\n';
    }
}
