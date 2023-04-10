package rpgGame.controller;

import rpgGame.characterModel.RefactorGameCharacter;
import rpgGame.characterModel.RefactorMonster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorGameManager {
    private List<RefactorMonster> monsterList;
    private List<RefactorGameCharacter> characterList;

    final int MONSTER_MAX_NUMBER = 2;
    final int CHARACTER_MAX_NUMBER = 3;
    final int ATTACKER_IS_PLAYER = 333;
    final int ATTACKER_IS_MONSTER = 777;

    public RefactorGameManager() {
        final int PLAYER_HP_MIN = 100;
        final int PLAYER_HP_MAX = 200;
        final int PLAYER_STAT_MIN = 15;
        final int PLAYER_STAT_MAX = 20;

        final int MONSTER_HP_MIN = 200;
        final int MONSTER_HP_MAX = 300;
        final int MONSTER_STAT_MIN = 20;
        final int MONSTER_STAT_MAX = 30;

        // monsterList, characterList 초기화
        monsterList = new ArrayList<>();
        characterList = new ArrayList<>();

        for (int i = 0; i < CHARACTER_MAX_NUMBER; i++) {
            final RefactorMonster monster = new RefactorMonster(
                    MONSTER_STAT_MIN, MONSTER_STAT_MAX, MONSTER_HP_MIN, MONSTER_HP_MAX);
            // monsterList 에 monster 의 특성을 할당
            monsterList.add(monster);
        }

        for (int i = 0; i < CHARACTER_MAX_NUMBER; i++) {
            final RefactorGameCharacter playerCharacter = new RefactorGameCharacter(
                    PLAYER_STAT_MIN, PLAYER_STAT_MAX, PLAYER_HP_MIN, PLAYER_HP_MAX);
            // characterList 에 playerCharacter 의 특성을 할당
            characterList.add(playerCharacter);
        }
    }
    public void playGame() throws InterruptedException {

        int turn = 1;
        for (; ; turn++) {
            System.out.println("현재 턴: " + turn);

            final Boolean isAllMonsterKilled = turnBehavior(characterList, monsterList, ATTACKER_IS_PLAYER);
            if (isAllMonsterKilled) {
                System.out.println("player 승리!");
                break;
            }
            final Boolean isAllPlayerDeath = monsterTurnBehavior();
            if (isAllPlayerDeath) {
                System.out.println("Player 패배!");
                break;
            }

            printBattleInfo();

            Thread.sleep(1000);
        }
    }
    private <T, U> boolean turnBehavior (List<T> attackerList, List<U> defenderList, int castingType) {

        Boolean isAllKilled = true;

        for (int attackerIdx = 0; attackerIdx < attackerList.size(); attackerIdx++) {
            final int defenderIdx = CustomRandom.generateNumber(defenderList.size() - 1);
            final U defender = defenderList.get(defenderIdx);
            final T attacker = attackerList.get(attackerIdx);

            useTargetingSkill(castingType, defender, attacker);
            decisionDeath(defenderList, castingType, defenderIdx, defender);

            if (defenderList.size() == 0) {
            return isAllKilled;
        }
    }
        return false;
}

    private <T, U> void useTargetingSkill(int castingType, U defender, T attacker) {
        if (castingType == ATTACKER_IS_PLAYER) {
            ((RefactorGameCharacter) attacker).targetingSkill(defender);
        } else {
            ((RefactorMonster) attacker).targetingSkill(defender);
        }
    }

    private <U> void decisionDeath(List<U> defenderList, int castingType, int defenderIdx, U defender) {
        if (castingType == ATTACKER_IS_PLAYER) {
            if (((RefactorMonster)defender).decisionDeath()) {
                defenderList.remove((defenderIdx));
            }
        }else {
            if (((RefactorGameCharacter)defender).decisionDeath()) {
                defenderList.remove(defenderIdx);
            }
        }
    }
    private void printBattleInfo() {
        System.out.println("캐릭터 상태 정보: ");
        System.out.println(characterList);
        System.out.println();
        System.out.println("몬스터 상태 정보: ");
        System.out.println(monsterList);
    }

    private Boolean monsterTurnBehavior() {
        final Boolean killedAllPlayer = true;

        for (int monsterIdx = 0; monsterIdx < monsterList.size(); monsterIdx++) {
            final RefactorMonster monster = monsterList.get(monsterIdx);

            final int characterIdx = CustomRandom.generateNumber(characterList.size() - 1);
            final RefactorGameCharacter character = characterList.get(characterIdx);

            monster.targetingSkill(character);

            if (character.decisionDeath()) {
                characterList.remove(characterIdx);
            }

            if (characterList.size() == 0) {
                return killedAllPlayer;
            }
        }
        return false;
    }

    private Boolean playerTurnBehavior() {
        final Boolean killedAllMonster = true;

        for (int characterIdx = 0; characterIdx < characterList.size(); characterIdx++) {
            final RefactorGameCharacter character = characterList.get(characterIdx);

            final int monsterIdx = CustomRandom.generateNumber(monsterList.size() - 1);
            final RefactorMonster monster = monsterList.get(monsterIdx);

            character.targetingSkill(monster);

            if (monster.decisionDeath()) {
                monsterList.remove(monsterIdx);
            }

            if (monsterList.size() == 0) {
                return killedAllMonster;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RefactorGameManager2{" +
                "monsterList=" + monsterList +
                ", characterList=" + characterList +
                '}';
    }
}
