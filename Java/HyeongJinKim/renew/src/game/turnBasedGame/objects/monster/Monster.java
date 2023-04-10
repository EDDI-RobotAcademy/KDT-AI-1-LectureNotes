package game.turnBasedGame.objects.monster;

import game.turnBasedGame.objects.player.PlayerInfo;
import utility.random.CustomRandom;

public class Monster {
    private int attackDMG;
    private int min = 10;
    private int max = 15;
    private int healthPoint;

    public Monster() {
        this.healthPoint = 50;
        this.attackDMG = CustomRandom.generateNumber(min, max);
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void monsterAttack(PlayerInfo playerInfo) {
        playerInfo.setHealthPoint(playerInfo.getHealthPoint() - attackDMG);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "attackDMG=" + attackDMG +
                ", min=" + min +
                ", max=" + max +
                ", healthPoint=" + healthPoint +
                '}';
    }
}
