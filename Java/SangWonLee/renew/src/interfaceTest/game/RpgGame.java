package interfaceTest.game;

import interfaceTest.character.GameCharacter;
import interfaceTest.character.Monster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RpgGame {
    final int CHARACTER_NUMBER = 3; // 게임 플레이어의 숫자.
    final int MONSTER_NUM = 2; // 몬스터의 숫자
    List<GameCharacter> gameCharacterList; // 게임 플레이어 리스트
    List<Monster> monsterList; // 몬스터 리스트

    public RpgGame() {
        gameCharacterList = new ArrayList<>();

        for (int i = 0; i < CHARACTER_NUMBER; i++) {
            GameCharacter gameCharacter = new GameCharacter(); // 게임 플레이어 생성자
            gameCharacterList.add(gameCharacter); // 게임 플레이어를 리스트에 추가
        }

        monsterList = new ArrayList<>();

        for (int i = 0; i < MONSTER_NUM; i++) {
            Monster monster = new Monster(); // 몬스터 생성자
            monsterList.add(monster); //몬스터를 리스트에 추가
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 1;
        for (int i = 0; ; i++) { // 계속 돌기
            System.out.println("현재 턴: " + (turn++));

            // 첫 번째 스킬은 타겟팅 스킬
            // 누굴 타겟팅 할 것인가: 랜덤
            for (int characterIndex = 0; characterIndex < gameCharacterList.size(); characterIndex++) { // 게임 플레이어 한명한명 돌리기
                final GameCharacter gameCharacter = gameCharacterList.get(characterIndex);

                Boolean isDeath = true;
                int targetMonsterIndex = 0;
                Monster monster = null;

                do {
                    targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUM - 1); // 몬스터 둘중 하나의 Index 번호
                    monster = monsterList.get(targetMonsterIndex); // monsterList에서 Index번호로 monster 지정
                    isDeath = monster.getStatus() == monster.DEATH ? true : false; // monster의 status가 DEATH인 상태면 true, 아니면 false

                    Boolean isEveryMonsterKilled = false; // 모든 몬스터가 DEATH 되었을 때 필요한 Boolean
                    for (int monsterIdx = 0; monsterIdx < monsterList.size(); monsterIdx++) { // monster list 한명한명 돌리기
                        final Monster tmpMonster = monsterList.get(monsterIdx); //

                        if (tmpMonster.getStatus() == tmpMonster.DEATH) {
                            isEveryMonsterKilled = true;
                        } else {
                            isEveryMonsterKilled = false;
                            break;
                        }
                    }

                    if (isEveryMonsterKilled) { return; }

                } while (isDeath);

                gameCharacter.firstSkill(monster);

                for (int monsterIndex = 0; monsterIndex < monsterList.size(); monsterIndex++) {
                    final Monster selectedMonster = monsterList.get(monsterIndex);
                    if (selectedMonster.getHp() <= 0) {
                        selectedMonster.setStatus(selectedMonster.DEATH);
                    }
                }
            }

            System.out.println(monsterList);

            for (int monsterIndex = 0; monsterIndex < monsterList.size(); monsterIndex++) {
                final Monster monster = monsterList.get(monsterIndex);
                final int targetCharacterIndex = CustomRandom.generateNumber(CHARACTER_NUMBER - 1);
                final GameCharacter gameCharacter = gameCharacterList.get(targetCharacterIndex);

                monster.firstSkill(gameCharacter);
            }

            System.out.println(gameCharacterList);

            // 두 번째 스킬은 광역 스킬

            Thread.sleep(1000); // 1초 대기
        }
    }

    @Override
    public String toString() {
        return "RpgGame{" +
                "gameCharacterList=" + gameCharacterList +
                ", monsterList=" + monsterList +
                '}';
    }
}