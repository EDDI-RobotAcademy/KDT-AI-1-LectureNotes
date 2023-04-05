package rpgGame.controller;

import rpgGame.characterModel.RefactorGameCharacter;
import rpgGame.characterModel.RefactorMonster;
import rpgGame.characterModel.Status;
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
                    MONSTER_STAT_MIN, MONSTER_STAT_MAX,MONSTER_HP_MIN, MONSTER_HP_MAX);

            monsterList.add(monster);
        }

        for (int i = 0; i < CHARACTER_MAX_NUMBER; i++) {
            final RefactorGameCharacter playCharacter = new RefactorGameCharacter(
                    PLAYER_STAT_MIN, PLAYER_STAT_MAX,PLAYER_HP_MIN, PLAYER_HP_MAX);

            characterList.add(playCharacter);
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 1;

        for (; ; turn++) {
            System.out.println("현재 턴: " + turn);


            final Boolean isAllMonsterKilled = playerTurnBehavior(); // Ctrl + Alt + M
            if (isAllMonsterKilled) {
                System.out.println("Player 승리!");
                break;
            }

            final Boolean isAllPlayerDeath = monsterTurnBehavior(); // Ctrl + Alt + M
            if (isAllPlayerDeath) {
                System.out.println("Player 패배!");
                break;
            }
            printBattleInfo();

            Thread.sleep(1000);
        }
    }


    private void printBattleInfo() {
        System.out.println("캐릭터 상태 정보: ");
        System.out.println(characterList);
        System.out.println();
        System.out.println("몬스터 상태 정보: ");
        System.out.println(monsterList);
    }

    private Boolean playerTurnBehavior() {
        final Boolean killedAllMonster = true;

        for (int characterIndex = 0; characterIndex < characterList.size(); characterIndex++) {
            final RefactorGameCharacter character = characterList.get(characterIndex);

            final int monsterIndex =  CustomRandom.generateNumber(monsterList.size() - 1);
            final RefactorMonster monster = monsterList.get(monsterIndex);

            character.targetingSkill(monster);

            if (monster.decisionDeath()) {
                monsterList.remove(monsterIndex);
            }

           if (monsterList.size() == 0) {
               return  killedAllMonster;
           }
        }

        return false;
    }

    private Boolean monsterTurnBehavior() {
        final Boolean killedAllCharacter = true;

        for (int monsterIndex = 0; monsterIndex < monsterList.size(); monsterIndex++) {
            final RefactorMonster monster = monsterList.get(monsterIndex);

            final int characterIndex =  CustomRandom.generateNumber(characterList.size() - 1);
            final RefactorGameCharacter character = characterList.get(characterIndex);

            monster.targetingSkill(character);

            if (character.decisionDeath()) {
                characterList.remove(characterIndex);
            }

            if (characterList.size() == 0) {
                return  killedAllCharacter;
            }
        }

        return false;
    }


    @Override
    public String toString() {
        return "RefactorGameManager{" +
                "monsterList=" + monsterList +
                ", characterList=" + characterList +
                '}';
    }


}