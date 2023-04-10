package rpgGame.characterModel;

import utility.random.CustomRandom;

public class RefactorGameCharacter extends CharacterModel implements Skill {

    public RefactorGameCharacter(int statMin, int statMax, int hpMin, int hpMax) {

        super(CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(hpMin, hpMax));
    }

    @Override
    public void targetingSkill(Object target) {
        final RefactorMonster monster = (RefactorMonster) target;
        final int damage = (int) (getStrength() * 3.3f + getDexterity() * 2.7f + getAgility() * 0.6);
        monster.calculateDamage(damage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}