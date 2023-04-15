package customLibrary.diceGame.component;

import java.util.List;

public class Player implements Comparable<Player> {
    final private int order;
    private static int orderSequence = 0;
    private int score;
    private int diceNumber;
    final private int EVEN_DICISION = 2;
    final private int EVEN = 0;
    final private int ODD = 1;
    private boolean alive;

    public Player() {
        order = orderSequence++;
        alive = true;

    }

    private boolean isAlive() {
        return alive;
    }

    public void play() {
        Dice dice = new Dice();
        diceNumber = dice.rollDice();
        score = diceNumber;
    }

    private void decreseScore() {
        this.score -= 1;
        if (this.score == 0) {
            this.alive = false;
        }
    }

    public void attack(List<Player> playerList) {
        if (!isAlive()) return;

        final int attackTarget;
        if (this.diceNumber % EVEN_DICISION == EVEN) {
            attackTarget = ODD;
        } else {
            attackTarget = EVEN;
        }


        for (Player player : playerList) {
            if (!player.isAlive()) {
                continue;
            }

            if (player.order % EVEN_DICISION == attackTarget) {
                player.decreseScore();

            }
        }
    }

    @Override
    public int compareTo(Player player) {
        return player.score - this.score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "order=" + order +
                ", score=" + score +
                ", diceNumber=" + diceNumber +
                ", alive=" + alive +
                '}' + '\n';
    }

    public int getScore() {
        return this.score;
    }
}
