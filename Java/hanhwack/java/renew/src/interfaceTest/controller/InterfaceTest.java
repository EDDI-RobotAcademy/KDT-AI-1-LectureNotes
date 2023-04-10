package interfaceTest.controller;

import interfaceTest.character.GameCharacter;
import interfaceTest.game.RpgGame;

public class InterfaceTest {

    public static void main(String[] args) throws InterruptedException {
        RpgGame rpgGame = new RpgGame() ;
        System.out.println(rpgGame);

        rpgGame.playGame();

    }
}
