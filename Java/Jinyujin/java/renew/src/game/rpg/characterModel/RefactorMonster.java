package game.rpg.characterModel;
// 캐릭터모델 만들고 리팩터몬스터 생성 → 상속

// 주의: 상속은 재사용성을 위해 사용하지 않습니다.
// Type Hierarchy를 만들기 위해 사용합니다.
// Type Hierarchy 란? 타입 계층구조를 만든다는게 뭘까?

import utility.random.CustomRandom;

// 일방적인 관리 -> 위에서 아래를 관리한다? X
// 타입 계층구조를 만든다는 것은 캐릭터라는 기본 스펙을 공통적으로 제공해주겠다는 뜻
// 고로 캐릭터 계열의 모든 데이터 타입들은 상속된 정보들을 공통되게 사용할 수 있습니다.
// 게임캐릭터 같은 경우 아니라면 재사용성을 위해 상속을 사용하지 말 것!
// 이런 경우 아니면 상속 거의 사용하지 않음
public class RefactorMonster extends CharacterModel implements Skill {
    // 왼쪽이 오른쪽 꺼를 상속받음
    // RefactorMonster가 CharacterModel을 상속받음
    // 타입을 계층화하기 위해서가 아니라 재사용하기 위해 상속하는건 옳지 않음
    // 상속에 대한 문법은 익혀둘 것

    public RefactorMonster(int statMin, int statMax, int hpMin, int hpMax) { // 아직 몬스터하고 어떤 차이를 봐야 하는지 모르겠음 -> 일단 생성자 만들기
        // super는 상속된 정보의 생성자를 호출함(CharacterModel) - 공부할 것!!!
        super(CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(hpMin, hpMax));  // 상속된 정보의 생성자 호출
    } //이거 호출한 다는 뜻임

    @Override
//    public void targetingSkill(Object target) { // 마찬가지로 타입 바꿔줘야함
    public <T> void targetingSkill(T target) {
        final RefactorGameCharacter character = (RefactorGameCharacter) target;
        final int damage = (int) (getStrength() * 1.7f + getDexterity() * 2.5f + getAgility() * 0.6f);
        character.calculateDamage(damage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
