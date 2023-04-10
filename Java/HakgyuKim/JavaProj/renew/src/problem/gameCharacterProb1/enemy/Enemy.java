package problem.gameCharacterProb1.enemy;


import problem.gameCharacterProb1.Character;
import utility.random.CustomRandom;

public class Enemy {
    final private String name;
    private int health;
    final private int MIN = 3;
    final private int MAX = 10;
    final private int attack;

    public Enemy (String name) {
        this.name = name;
        this.health = 45;
        this.attack = CustomRandom.generateNumber(MIN, MAX);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void enemyAtk (Character character) {
        character.setHealth(character.getHealth() - attack);
    }
}
