package game.rpg.characterModel;

import utility.random.CustomRandom;

public class RefactorGameCharacter extends CharacterModel implements Skill{
    public RefactorGameCharacter(int statMin, int statMax, int hpMin, int hpMax) {
    // super() -> 상속된 정보의 생성자를 호출합니다. (CharacterModel의 생성자가 되겠죠?)
        super( CustomRandom.generateNumber(statMin, statMax),
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
    public <T> void targetingSkill(T target) {
        final RefactorMonster monster = (RefactorMonster) target;
        final int damage = (int) (getStrength() * 3.3f + getDexterity() * 2.7f + getAgility() * 0.6);
        monster.calculateDamage(damage);
    }
}
