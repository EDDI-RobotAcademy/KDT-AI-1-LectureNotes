package interfaceTest2.charatcterModel2;

import random.CustomRandom;

public class GameCharacter2 extends CharacterModel2 implements Skill {
    public GameCharacter2(int statMin,int statMax, int hpMin, int hpMax){

        super (CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(statMin,statMax),
                CustomRandom.generateNumber(hpMin,hpMax));
    }
    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public <T> void targetingSkill(T target) {
        final Monster2 monster2 = (Monster2) target;
        final int damage = (int)(getStrength()*1.7f + getDexterity()*2.5f +
                getAgility()*0.6);
        monster2.calculateDamage(damage);
    }
}
