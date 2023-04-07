package homework.eighth.characterGame.controller;

import homework.eighth.characterGame.CharGameManager;

public class CharacterGameController {
    public static void main(String[] args) {
        CharGameManager charGameManager = new CharGameManager();
        System.out.println(charGameManager);

        charGameManager.play();
        charGameManager.printPlayer();
    }
}