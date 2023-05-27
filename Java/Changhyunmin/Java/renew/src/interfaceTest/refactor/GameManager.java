package interfaceTest.refactor;

import dicegame.game.Player;
import random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<RefactorMonster>monsterList;
    private List<RefactorGameCharacter>gameCharacterList;

    final int MONSTER_MAX_NUMBER = 2;
    final int CHARATER_MAX_NUMBER = 3;
    private boolean isAllPlayerDeath;

    public GameManager(){
        final int PLAYER_HP_MIN = 70;
        final int PLAYER_HP_MAX = 150;
        final int PLAYER_START_MIN = 10;
        final int PLAYER_START_MAX = 20;

        final int MONSTER_HP_MIN = 200;
        final int MONSTER_HP_MAX = 300;
        final int MONSTER_START_MIN = 20;
        final int MONSTER_START_MAX = 30;


        final int PLAYER_ATTACK = 333;
        final int MONSTER_ATTACK = 777;

        monsterList = new ArrayList<>();
        gameCharacterList = new ArrayList<>();

        for (int i = 0; i < MONSTER_MAX_NUMBER; i++){
            final RefactorMonster monster = new RefactorMonster(
                    MONSTER_START_MIN, MONSTER_START_MAX, MONSTER_HP_MIN, MONSTER_HP_MAX);
            monsterList.add(monster);

        }
        for (int i = 0; i < CHARATER_MAX_NUMBER; i++){
            final RefactorGameCharacter character = new RefactorGameCharacter(
                    PLAYER_START_MIN, PLAYER_START_MAX, PLAYER_HP_MIN, PLAYER_HP_MAX);
            gameCharacterList.add(character);
        }
    }
    private void playGame() throws InterruptedException{
        int turn = 1;

        for (;;turn++){
            System.out.println("현재 턴: " + turn);
               // final Boolean isAllMonsterKilled = playerTurnBehavior();
                final Boolean isAllMonsterKilled = playerTurnBehavior();
                if (isAllMonsterKilled){
                    System.out.println("Player 승리!");
                    break;
                }
                final Boolean isAllMonsterDeath = monsterTurnBehavior();
                if (isAllPlayerDeath){
                    System.out.println("패배!");
                    break;
                }

                printBattleInfo();

                Thread.sleep(1000);

            }
        }

    private Boolean playerTurnBehavior() {
        return null;
    }

    private Boolean monsterTurnBehavior() {
        return null;
    }

    private void printBattleInfo() {
        System.out.println("캐릭터 상태 정보");
        System.out.println(gameCharacterList);
        System.out.println("몬스터 상태 정보");
        System.out.println(monsterList);
    }

//    private Boolean turnBehavior(List<?> attackerList, List<?> defenderList, int casting) {
//        final Boolean allKill = true;
//
//        for (int attackerIdx = 0; attackerIdx < attackerList.size(); attackerIdx++) {
//            final int defenderIdx = CustomRandom.generateNumber(defenderList.size() - 1);
//
//            if (casting == PLAYER_ATTACK) {
//                final RefactorMonster defender = (RefactorMonster) defenderList.get(defenderIdx);
//                final RefactorGameCharacter attacker = (RefactorGameCharacter) attackerList.get(attackerIdx);
//                attacker.targetingSkill(defender);
//            } else if (casting == MONSTER_ATTACK) {
//                final RefactorGameCharacter defender = (RefactorGameCharacter) defenderList.get(defenderIdx);
//                final RefactorMonster attacker = (RefactorMonster) attackerList.get(attackerIdx);
//                attacker.targetingSkill(defender);
//            }
//
//            if (casting == PLAYER_ATTACK) {
//                final RefactorMonster defender = (RefactorMonster) (defenderList.get(defenderIdx));
//
//                if (defender.decisionDeath()) {
//                    defenderList.remove(defenderIdx);
//                }
//            } else {
//                final RefactorGameCharacter defender = (RefactorGameCharacter) (defenderList.get(defenderIdx));
//
//                if (defender.decisionDeath()) {
//                    defenderList.remove(defenderIdx);
//                }
//            }
//
//            if (defenderList.size() == 0) {
//                return allKill;
//            }
//        }
//
//        return false;
//    }
//    }
    @Override
    public String toString() {
        return "GameManager{" +
                "monsterList=" + monsterList +
                ", gameCharacterList=" + gameCharacterList +
                '}';
    }
}
