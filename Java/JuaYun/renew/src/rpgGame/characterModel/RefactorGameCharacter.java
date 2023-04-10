package rpgGame.characterModel;

import utility.random.CustomRandom;

// extends는 상속 = 클래스 RefactorGameCharacter은 클래스CharacterModel을 상속받음.

// implements 또한 상속이지만 가장 큰 특징은 부모의 메소드를 반드시 재정의 해야함.
// 다중상속을 대신해줌
public class RefactorGameCharacter extends CharacterModel implements  Skill {
    public RefactorGameCharacter(int statMin, int statMax, int hpMin, int hpMax) {

        // strength, intelligent, dexterity, agility, hp
        super(CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(hpMin, hpMax));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public <T> void targetingSkill(T target) {  // (RefactorMonster) 형변환을 의미
        // 이부분은 몬스터에게 입힐 데미지 설정
        final RefactorMonster monster = (RefactorMonster) target;
        final int damage = (int) (getStrength() * 1.7f + getDexterity() * 2.5f + getAgility() * 0.6);
        monster.calculateDamage(damage);
    }
}

