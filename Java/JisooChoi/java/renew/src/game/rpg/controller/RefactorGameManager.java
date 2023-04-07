package game.rpg.controller;

import game.rpg.characterModel.RefactorGameCharacter;
import game.rpg.characterModel.RefactorMonster;
import game.rpg.characterModel.Status;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorGameManager {
    // 필드
    private List<RefactorMonster> monsterList;
    private List<RefactorGameCharacter> characterList;

    final int MONSTER_MAX_NUMBER = 2;
    final int CHARACTER_MAX_NUMBER = 3;
    final int ATTACKER_IS_PLAYER = 333;
    final int ATTACKER_IS_MONSTER = 777;

    // 생성자
    public RefactorGameManager() {
        final int PLAYER_HP_MIN = 100;
        final int PLAYER_HP_MAX = 200;
        final int PLAYER_STAT_MIN = 15;
        final int PLAYER_STAT_MAX = 20;

        final int MONSTER_HP_MIN = 200;
        final int MONSTER_HP_MAX = 300;
        final int MONSTER_STAT_MIN = 20;
        final int MONSTER_STAT_MAX = 30;

        monsterList = new ArrayList<>();
        characterList = new ArrayList<>();

        for(int i = 0; i < MONSTER_MAX_NUMBER; i++){
            final RefactorMonster monster = new RefactorMonster(
                    MONSTER_STAT_MIN, MONSTER_STAT_MAX, MONSTER_HP_MIN, MONSTER_HP_MAX
            );
            monsterList.add(monster);
        }

        for(int i = 0; i < CHARACTER_MAX_NUMBER; i++){
            final RefactorGameCharacter playCharacter = new RefactorGameCharacter(
                    PLAYER_STAT_MIN, PLAYER_STAT_MAX, PLAYER_HP_MIN, PLAYER_HP_MAX
            );
            characterList.add(playCharacter);
        }
    }

    // 메서드
    public void playGame() throws InterruptedException {
        int turn = 1;

        for( ; ; turn++){
            System.out.println("현재 턴: " + turn);

            final Boolean isAllMonsterKilled = turnBehavior(characterList, monsterList, ATTACKER_IS_PLAYER);

            //final Boolean isAllMonsterKilled = playerTurnBehavior();
                                                // ↑ ctrl + alt + m : 코드를 메서드로 빠지게 만드는 법

            if(isAllMonsterKilled){
                // 모든 몬스터를 다 죽였으면 승리를 출력하고 해당 반복문을 나간다.
                // 다 안 죽었을 경우, 해당 조건문은 안 돌아가고, 아래 몬스터가 공격하는 코드로 간다.
                System.out.println("Player 승리 !");
                break;
            }

            final Boolean isAllPlayerDeath = monsterTurnBehavior();
            if (isAllPlayerDeath) {
                // 모든 character를 다 죽였으면 패배를 출력하고 해당 반복문을 나간다.
                // 다 안 죽었을 경우, 해당 조건문은 안 돌아가고, 해당 반복문이 한 번 더 실행된다.
                System.out.println("Player 패배!");
                break;
            }

            // 상태 정보 출력
            System.out.println("----------싸운 후 상태정보");
            printBattleInfo();

            Thread.sleep(1000);
        }
    }

    private <T, U> Boolean turnBehavior(List<T> attackerList, List<U> defenderList, int castingType){
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

    private <U> void decisionDeath(List<U> defenderList, int castingType, int defenderIdx, U defender) {
        if (castingType == ATTACKER_IS_PLAYER) {
            if (((RefactorMonster) defender).decisionDeath()) {
                defenderList.remove(defenderIdx);
            }
        } else {
            if (((RefactorGameCharacter) defender).decisionDeath()) {
                defenderList.remove(defenderIdx);
            }
        }
    }

    private <T, U> void useTargetingSkill(int castingType, U defender, T attacker) {
        if (castingType == ATTACKER_IS_PLAYER) {
            ((RefactorGameCharacter) attacker).targetingSkill(defender);
        } else {
            ((RefactorMonster) attacker).targetingSkill(defender);
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
        final Boolean killedAllPlayer  = true;

        for(int monsterIdx = 0; monsterIdx < monsterList.size(); monsterIdx++){
            final RefactorMonster monster = monsterList.get(monsterIdx);

            final int characterIdx = CustomRandom.generateNumber(characterList.size() - 1);
            final RefactorGameCharacter character = characterList.get(characterIdx);

            // character 공격 !
            monster.targetingSkill(character);

            // character가 죽었는지 안죽었는지 확인 !
            if (character.decisionDeath()) {
                // characterList 에서 제거
                characterList.remove(characterIdx);
            }

            // 모든 character가 죽었다면 리턴
            if (characterList.size() == 0) {
                return killedAllPlayer;
            }
        }
        return false;
    }

    private Boolean playerTurnBehavior() {
        final Boolean killedAllMonster = true;

        for(int characterIdx = 0; characterIdx < characterList.size(); characterIdx++){
            final RefactorGameCharacter character = characterList.get(characterIdx);

            final int monsterIdx = CustomRandom.generateNumber(monsterList.size()-1);
            final RefactorMonster monster = monsterList.get(monsterIdx);

            // monster 공격 !
            character.targetingSkill(monster);

            // monster 죽었는지 안죽었는지 확인 !
            if (monster.decisionDeath()) {
                // 죽었다면 monsterList 에서 제거
                monsterList.remove(monsterIdx);
            }

            // monsterList 에 모든 몬스터가 없다면
            if (monsterList.size() == 0) {
                // monster가 다 죽었다.
                return killedAllMonster;
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
