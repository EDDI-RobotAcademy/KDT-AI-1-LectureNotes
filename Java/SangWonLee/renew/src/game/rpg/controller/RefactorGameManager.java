package game.rpg.controller;

import game.rpg.characterModel.RefactorGameCharacter;
import game.rpg.characterModel.RefactorMonster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorGameManager {

    private List<RefactorMonster> monsterList;
    private List<RefactorGameCharacter> characterList;

    final int MONSTER_MAX_NUMBER = 2;
    final int CHARACTER_MAX_NUMBER = 3;

    public RefactorGameManager() {
        final int PLAYER_HP_MIN = 70;
        final int PLAYER_HP_MAX = 150;
        final int PLAYER_STAT_MIN = 10;
        final int PLAYER_STAT_MAX = 20;

        final int MONSTER_HP_MIN = 200;
        final int MONSTER_HP_MAX = 300;
        final int MONSTER_STAT_MIN = 20;
        final int MONSTER_STAT_MAX = 30;

        monsterList = new ArrayList<>();
        characterList = new ArrayList<>();

        for (int i = 0; i < MONSTER_MAX_NUMBER; i++) {
            final RefactorMonster monster = new RefactorMonster(
                    MONSTER_HP_MIN, MONSTER_HP_MAX, MONSTER_STAT_MIN, MONSTER_STAT_MAX);

            monsterList.add(monster);
        }

        for (int i = 0; i < CHARACTER_MAX_NUMBER; i++) {
            final RefactorGameCharacter playCharacter = new RefactorGameCharacter(
                    PLAYER_HP_MIN, PLAYER_HP_MAX, PLAYER_STAT_MIN, PLAYER_STAT_MAX);

            characterList.add(playCharacter);
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 1;

        for (; ; turn++){
            System.out.println("현재 턴 : " + turn);

            for (int characterIdx = 0; characterIdx < CHARACTER_MAX_NUMBER; characterIdx++){

                final RefactorGameCharacter character = characterList.get(characterIdx);
                final RefactorMonster monster = monsterList.get(CustomRandom.generateNumber(MONSTER_MAX_NUMBER - 1));

//                character.skill(monster);


            }

            Thread.sleep(1000);
        }
    }

    @Override
    public String toString() {
        return "RefactorGameManager{" +
                "monsterList=" + monsterList +
                ", characterList=" + characterList +
                '}';
    }
}