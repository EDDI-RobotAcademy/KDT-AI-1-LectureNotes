package homework9.component.character;

import homework9.gameSystem.utility.MonsterIdGenerator;

public class Monster {
    final private int monsterId;
    private int hp;

    public Monster() {
        hp = 50;
        monsterId = MonsterIdGenerator.generateId();
    }

    final int DAMAGE = 5;

    public int getHp() {
        return hp;
    }

    public void decreaseHp(int decreasePoint) {
        this.hp = this.hp - decreasePoint;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public int getDamage() {
        return DAMAGE;
    }
}
