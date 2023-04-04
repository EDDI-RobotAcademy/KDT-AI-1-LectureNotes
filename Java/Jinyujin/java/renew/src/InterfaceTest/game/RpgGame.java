package InterfaceTest.game;

import InterfaceTest.character.GameCharacter;
import InterfaceTest.character.Monster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RpgGame {
    final int CHARACTER_NUMBER = 3;
    final int MONSTER_NUMBER = 2;

    List<GameCharacter> gameCharacterList;
    List<Monster> monsterList; // 몬스터 인터페이스 생성 후 선언

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

    public void playGame() throws InterruptedException { // 어떤 식으로 구성하냐에 따라 달라질 것
        // 만들어진 몬스터와 플레이어의 공방전
        int round = 1;
        for (int i = 0; ; i++) { // 싸움이 끝날때까지 싸우는거라 조건 없음
            // 전투 과정이 후다닥 끝나는 것보다 보이는 것이 필요함
            System.out.println("현재 라운드: " + (round++)); // round 대신 turn이라고 해도 됨

            // 첫 번째 스킬은 타겟팅 스킬
            // 누굴 타겟킹 할 것인가: 랜덤 지정
            for (int charaterIndex = 0; charaterIndex < gameCharacterList.size(); charaterIndex++) {
                final GameCharacter gameCharacter = gameCharacterList.get(charaterIndex) ;// 바깥 for문의 i는 라운드 수니까 새로 생성

                boolean isDeath = true;
                int targetMonsterIndex = 0;
                Monster monster = null;

                do {
                    targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUMBER - 1);
                    monster = monsterList.get(targetMonsterIndex);
                    isDeath = monster.getStatus() == monster.DEATH ? true : false; // 몬스터 죽었으면 트루고 아니면 살았다

                    Boolean isEveryMonsterKilled = false;
                    for (int monsterIdx = 0; monsterIdx < monsterList.size(); monsterIdx++) {
                        final Monster tmpMonster = monsterList.get(monsterIdx);

                        if (tmpMonster.getStatus() == monster.DEATH) {
                            isEveryMonsterKilled = true;
                        } else {
                            isEveryMonsterKilled = false;
                            break; // 루프 돌고 있기 때문에
                        }
                    }

                    if (isEveryMonsterKilled) { return;} // 모든 몬스터 죽으면 루프 끝내라
                    // isEveryMonsterKilled 이걸 판정하는 것이 관건이 될 것 - 위에 for 문

                }  while (isDeath); // 죽었으면 다시 몬스터타겟 지정하도록
                // 죽었으면 트루니까 다시 돌아라 -> 다시 때려라
                // 이제 이 상태에서 죽은 애 안때리는지 봐야함
                // do-while문 때문에 몬스터 다 죽으면 멈춤
                // 게임 끝내려면 몬스터 다 죽었다는걸 판정해야함 - 위에 if문

                gameCharacter.firstskill(monster); // 여기까지 누군지는 모르지만 아무나 타겟팅해서 팸
                // 여기까지 타겟 스킬인 흑염룡의 손톱만

                for (int monsterIndex = 0;monsterIndex < monsterList.size(); monsterIndex++) {
                    final Monster selectedMonster = monsterList.get(monsterIndex); // 캐릭터가 몬스터를 팼으니까 몬스터 상태 가져옴
                    if (selectedMonster.getHp() <= 0) {
                        selectedMonster.setStatus(selectedMonster.DEATH); // 죽었다는 걸 알려줌
                        // final int targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUMBER - 1); 랜덤타겟을 가져올 때
                        // 죽은 애애 대해서는 타겟을 못하게 해야함 -> boolean (아직 몬스터 죽은거만)
                    }
                }
            }

            // 팬 결과
            System.out.println(monsterList);

            // 몬스터도 플레이어를 때릴 수 잇도록
            for (int monsterIndex = 0; monsterIndex < monsterList.size(); monsterIndex++) {
                final Monster monster = monsterList.get(monsterIndex);
                final int targetCharacterIndex = CustomRandom.generateNumber(CHARACTER_NUMBER - 1);
                final GameCharacter gameCharacter = gameCharacterList.get(targetCharacterIndex);

                monster.firstskill(gameCharacter);
            }

            // 플레이어의 상태 정보
            System.out.println(gameCharacterList);

            // 두 번째 스킬은 광역 스킬

            Thread.sleep(1000); // 1초마다 대기 걸 수 있음
        }
    }

    @Override
    public String toString () {
        return "RpgGame{" +
                "gameCharacterList=" + gameCharacterList +
                ", monsterList=" + monsterList +
                '}';
    }
}
