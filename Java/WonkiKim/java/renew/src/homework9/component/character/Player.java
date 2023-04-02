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


}
