package homework6;

import homework6.game.Game;

public class DiceGame {

    public static void main(String[] args) {
        final int PLAYER_NUMBER = 2;
        final int TOTAL_ROUND = 3;

        Game game = new Game(PLAYER_NUMBER);
        game.play(TOTAL_ROUND);
        game.result();

    }
}
