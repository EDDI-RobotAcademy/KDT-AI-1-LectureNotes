package homework9.component.character;

import java.util.HashMap;

public class Player {
    final private Status status;
    final private String playerName;

    public Player() {
        status = new Status();
        playerName = "player1";
    }

    public Status getStatus() {
        return status;
    }

    public int getAllAttackDamage() {
        return status.getIntellect();
    }

    public float getExpectedAllAttackDamage() {
        return (float) status.getIntellect() * status.getAbility() / 10;
    }

    public void printStatus() {
        System.out.println("체력: " + status.getHp());
        System.out.println("마나: " + status.getMp());
        System.out.println("완력: " + status.getStrength());
        System.out.println("민첩: " + status.getAgility());
        System.out.println("재주: " + status.getAbility());
        System.out.println("지력: " + status.getIntellect());
    }


}
