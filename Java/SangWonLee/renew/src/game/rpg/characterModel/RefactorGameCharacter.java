package game.rpg.characterModel;

import interfaceTest.character.Monster;
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
    public String toString() {
        return super.toString();
    }

    @Override
    public <T> void targetingSkill(T target) {
        final RefactorMonster monster = (RefactorMonster) target;
        final int damage = (int) (getStrength() * 1.7f + getDexterity() * 2.5f + getAgility() * 0.6);
        monster.calculateDamage(damage);
    }
}