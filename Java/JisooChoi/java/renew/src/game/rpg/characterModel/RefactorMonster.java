package game.rpg.characterModel;

// 상속은 재사용성을 위해서 사용하지 않습니다.
// Type Hierarchy (= 타입 계층구조)를 만들기 위해 사용합니다.

// 일반적인 관리 -> 위에서 아래를 관리한다 ? X
// 타입 계층구조를 만든다는 것은 캐릭터라는 기본 스펙을 공통적으로 제공해주겠다는 뜻
// 고로 캐릭터 계열의 모든 데이터 타입들은 상속된 정보들을 공통되게 사용할 수 있다.

import utility.random.CustomRandom;

import java.util.List;

public class RefactorMonster extends CharacterModel implements Skill{

    // List<Integer> integerList;
    // Collection: 정보 묶음 (여기에는 linkedHash나 linkedSet 같은 것들이 들어있다.)
    // Iterable: 반복

    public RefactorMonster(int statMin, int statMax, int hpMin, int hpMax) {
        // super() -> 상속된 정보의 생성자를 호출합니다. (CharacterModel의 생성자가 되겠죠?)
        super( CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(hpMin, hpMax));
    }

    @Override
    public <T> void targetingSkill(T target) {
        final RefactorGameCharacter character = (RefactorGameCharacter) target;
        final int damage = (int) (getStrength() * 1.7f + getDexterity() * 2.7f + getAgility() * 0.6);
        character.calculateDamage(damage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
