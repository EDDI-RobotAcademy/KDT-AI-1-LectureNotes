package interfacePractice.game;

import interfacePractice.character.GameCharacter;
import interfacePractice.character.Monster;
import utility.Random;

import java.util.ArrayList;
import java.util.List;

public class RpgGame {
    final int CHARACTER_NUMBER = 3;
    final int MONSTER_NUMBER = 2;
    List<GameCharacter> gameCharacterList;
    List<Monster> monsterList;

    public RpgGame() {
        gameCharacterList = new ArrayList<>();
        for (int i = 0; i < CHARACTER_NUMBER; i++) {
            GameCharacter gameCharacter = new GameCharacter();
            gameCharacterList.add(gameCharacter);
        }

        monsterList = new ArrayList<>();
        for (int i = 0; i < MONSTER_NUMBER; i++) {
            Monster monster = new Monster();
            monsterList.add(monster);
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 1;
        for (int i = 0; ; i++) {
            System.out.println("현재 턴: " + (turn++));

            for (int characterIndex = 0; characterIndex < gameCharacterList.size(); characterIndex++) {
                final GameCharacter gameCharacter = gameCharacterList.get(characterIndex);

                Boolean isDeath = true;
                int targetMonsterIndex = 0;
                Monster monster = null;

                do {
                    targetMonsterIndex = Random.generateNumber(MONSTER_NUMBER - 1);
                    monster = monsterList.get(targetMonsterIndex);
                    isDeath = monster.getStatus() == monster.DEATH ? true : false;

                    Boolean isEveryMonsterKilled = false;
                    for (int monsterIdx = 0; monsterIdx < monsterList.size(); monsterIdx++) {
                        final Monster tmpMonster = monsterList.get(monsterIdx);

                        if (tmpMonster.getStatus() == tmpMonster.DEATH) {
                            isEveryMonsterKilled = true;
                        } else {
                            isEveryMonsterKilled = false;
                            break;
                        }
                    }

                    if (isEveryMonsterKilled) {
                        return;
                    }
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
                final int targetCharacterIndex = Random.generateNumber(CHARACTER_NUMBER - 1);
                final GameCharacter gameCharacter = gameCharacterList.get(targetCharacterIndex);
                monster.firstSkill(gameCharacter);
            }
            System.out.println(gameCharacterList);
            Thread.sleep(1000);
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
