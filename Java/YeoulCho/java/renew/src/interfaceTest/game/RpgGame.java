package interfaceTest.game;

import interfaceTest.character.GameCharacter;
import interfaceTest.character.Monster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RpgGame {
    final int CHARACTER_NUMBER = 3;
    final int MONSTER_NUM =2;
    List<GameCharacter> gameCharacterList;
    List<Monster> monsterList;

    public RpgGame(){
        gameCharacterList = new ArrayList<>();

        for(int i =0; i<CHARACTER_NUMBER; i++){
            GameCharacter gameCharacter = new GameCharacter();
            gameCharacterList.add(gameCharacter);
        }

        monsterList = new ArrayList<>();
        for(int i =0; i<MONSTER_NUM; i++){
            Monster monster = new Monster();
            monsterList.add(monster);
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 1;
        for (int i =0; ; i++){ // 무한루프해라
            System.out.println("현재 턴: " + (turn++));

            // 첫 번째 스킬은 타겟팅 스킬
            // 누굴 타겟팅 할 것인가: 랜덤
            for (int characterIndex = 0; characterIndex < gameCharacterList.size(); characterIndex++) {

                Boolean isDeath = true;         // 몬스터가 죽었는가 ?
                int targetMonsterIndex = 0;     // 몬스터 인덱스
                Monster monster = null;         // 몬스터 객체

                do { //do 조건에 상관없이 일단 한번은 돌아라
                    // 랜덤 타겟 (선택 타겟이라면 Scanner로 입력 받도록 만드세요)
                    targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUM - 1); //Index니까 0,1 이렇게 몬스터2마리
                    monster = monsterList.get(targetMonsterIndex);
                    // 몬스터가 죽었는가 ?
                    isDeath = monster.getStatus() == monster.DEATH ? true : false;

                    // 모든 몬스터가 죽었는지 검사하는 루프
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

                    // 몬스터를 다 잡았으면 루프(게임) 종료
                    if (isEveryMonsterKilled) { return; } //이 메서드 종료

                } while (isDeath);  // 이 루프는 이미 죽은 몬스터를 또 패지 않도록 방지하기 위함 //참이면 계속해라
                //while false면 내려가......

                // 게임 캐릭터[n] 정보 가져오기
                final GameCharacter gameCharacter = gameCharacterList.get(characterIndex);
                // 캐릭터 단일 타겟팅 스킬 사용
                gameCharacter.firstSkill(monster);

                // 루프 돌면서 몬스터가 죽었는지 검사함
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
