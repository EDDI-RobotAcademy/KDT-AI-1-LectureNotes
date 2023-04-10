package problem.gameCharacterProb1.enemy;

import utility.random.CustomRandom;

public class EnemyNormalAtk extends EnemyModel{
    public EnemyNormalAtk(String name, int health, int ATK_MIN, int ATK_MAX) {
        super(name, health, CustomRandom.generateNumber(ATK_MIN, ATK_MAX));
    }


}
