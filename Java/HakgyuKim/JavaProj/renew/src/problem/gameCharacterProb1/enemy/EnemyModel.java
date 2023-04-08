package problem.gameCharacterProb1.enemy;

public class EnemyModel {
    final private String name;
    private int health;
    final private int attack;

    public EnemyModel (String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
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

    public void calculateDamage (int damage) {
        health -= damage;
    }
}
