package problem.gameCharacterProb1.enemy;

import utility.random.CustomRandom;

public class EnemyWideAtk extends EnemyModel{
    public EnemyWideAtk(String name, int health, int ATK_MIN, int ATK_MAX) {
        super(name, health, CustomRandom.generateNumber(ATK_MIN, ATK_MAX));
    }

}
