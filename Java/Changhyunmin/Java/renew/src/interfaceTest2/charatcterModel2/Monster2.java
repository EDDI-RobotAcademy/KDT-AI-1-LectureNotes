package interfaceTest2.charatcterModel2;

import random.CustomRandom;

public class Monster2 extends CharacterModel2 implements Skill {
    // 일방적인 관리 -> 위에서 아래를 관리한다 ? X
// 타입 계층구조를 만든다는 것은 캐릭터라는 기본 스펙을 공통적으로 제공해주겠다는 뜻
// 고로 캐릭터 계열의 모든 데이터 타입들은 상속된 정보들을 공통되게 사용할 수 있습니다.

    public Monster2(int statMin,int statMax, int hpMin, int hpMax){

        //List<Integer> integerList;
        //Collection: 정보 묶음
        //Iterable: 반복

        super (CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(hpMin,hpMax));
    }

    @Override
    public <T> void targetingSkill(T target) {
        final GameCharacter2 character = (GameCharacter2) target;
        final int damage = (int) (getStrength() * 1.7f + getDexterity() * 2.5f + getAgility() * 0.6);
        character.calculateDamage(damage);

    }
    @Override
    public String toString(){
        return super.toString();
    }
}
