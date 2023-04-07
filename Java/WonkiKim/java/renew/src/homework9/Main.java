package homework9;

import homework9.gameSystem.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.makeMonster();
        game.battle();
        game.result();
    }

}
