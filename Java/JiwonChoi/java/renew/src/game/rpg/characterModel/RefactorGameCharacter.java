package game.rpg.characterModel;

import utility.random.CustomRandom;

public class RefactorGameCharacter extends CharacterModel {

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
}