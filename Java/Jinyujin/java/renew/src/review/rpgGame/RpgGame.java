package review.rpgGame;

import review.rpgGame.GameCharacter;
import review.rpgGame.Monster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RpgGame {
    // 어느 정도 게임캐릭터와 몬스터 만들었으니
    // 게임을 구현하겠지?
    // 게임캐릭터와 몬스터의 수 선언
    final int CHARACTER_NUMBER = 3;
    final int MONSTER_NUMBER = 2;
    List<GameCharacter> gameCharacterList;
    List<Monster> monsterList;

    public RpgGame() {
        // 게임캐릭터와 몬스터를 각각 배열에 넣어준다
        // 왜? 좀 더 확장하는 측면에서 추후 몬스터가 제거되거나
        // 새로 추가되거나 하는 상황이 발생할 수 있기 때문
        // 몬스터 난입이라는 관점 도는 게임 캐릭터의 추가 관점에서 필요하다
        // CHARACTER_NUMBER와 MONSTER_NUMBER만 바꿔주면 되니까

        // 게임캐릭터 리스트
        gameCharacterList = new ArrayList<>();

        for (int i = 0; i < CHARACTER_NUMBER; i++){
            GameCharacter gameCharacter = new GameCharacter();
            gameCharacterList.add(gameCharacter);
        }

        // 몬스터 리스트
        monsterList = new ArrayList<>();

        for (int i = 0; i < MONSTER_NUMBER; i++){
            Monster monster = new Monster();
            monsterList.add(monster);
        }
    }

    public void playGame() throws InterruptedException { // 게임 시작. 어떤 식으로 구성하냐에 따라 달라질 것
        // 게임캐릭터와 몬스터와의 공방전

        // 먼저 라운드 수 넣어줌
        // 왜? 전투 과정이 후다닥 끝나는 것보다
        // 싸우는 과정이 보이는 것이 필요함
        int round = 1; // 1라운드 부터니까 1로 초기화

        for (int i = 0; ; i++) { // 싸움이 끝날 때까지 싸우는거라 조건식이 따로 필요없다
            System.out.println("현재 라운드: " + (round++));

            // 라운드가 진행되는 for문 안에서 게임 진행

            // 먼저 게임캐릭터의 공격
            // 첫 번째 스킬은 타겟팅 스킬
            // 누굴 타겟팅 할 것인가: 랜덤 지정
            for (int characterIndex = 0; characterIndex < gameCharacterList.size(); characterIndex++) {
//                final GameCharacter gameCharacter = gameCharacterList.get(characterIndex);
//                final int targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUMBER - 1);
//                final Object monster = monsterList.get(targetMonsterIndex);
                // 캐릭터인덱스가 0부터 게임캐릭터 리스트의 사이즈까지 하나씩 늘어난다.
                // GameCharacter 클래스의 정보를 이용할 수 있는 gameCharacter라는 객체 생성
                // 타겟몬스터인덱스는 몬스터 수에서 하나 빼고 랜덤으로
                // 그리고 몬스터 리스트에서 타겟몬스터를 가져와서 monster라는 변수에 저장

                // *** fisrtSkill 실행 후 죽은거 판정하기 위함
                Boolean isDeath = true;     // isDeath 변수 선언하고 true라고 저장
                                            // - 몬스터가 죽었는가?
                int targetMonsterIndex = 0; // 몬스터 인덱스
                Monster monster = null;     // 몬스터 객체

                // do - while 문
                do {
                    // 몬스터 랜덤 타겟 생성 (선택 타겟이라면 Scanner로 입력 받으세요)
                    targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUMBER - 1);
                    monster = monsterList.get(targetMonsterIndex);
                    // 몬스터가 죽었는가? -> 몬스터 죽음 판정이 맨 마지막 코드였음!
                    isDeath = monster.getStatus() == monster.DEATH ? true : false;
                                                     // 몬스터 죽으면 true고 아니면 살았다

                    // 모든 몬스터가 죽었는지 검사하는 루프
                    // 왜 검사? 모든 몬스터 죽으면 게임 끝내야 하니까
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

                    // 몬스터 다 잡았으면 게임 종료
                    if (isEveryMonsterKilled) { return;} // 모든 몬스터 죽으면 루프 끝내라
                    // isEveryMonsterKilled - 위의 for문을 통해 이걸 판정하는 것이 관건이 될 것이다

                } while (isDeath); // 죽었으면 다시 몬스터타켓 지정하도록
                // 죽었으면 트루니까 다시 돌아라 -> 다시 때려라
                // 이제 이 상태에서 죽은 애 더 때리지 않는지 봐야함
                // do-while문 때문에 몬스터 다 죽으면 멈춤
                // 게임 끝내려면 몬스터 다 죽었다는걸 판정해야함 - 위의 if문
                // 이 루프는 이미 죽은 몬스터를 또 패지 않도록 방지하기 위함

                // 게임 캐릭터[n] 정보 가져오기
                final GameCharacter gameCharacter = gameCharacterList.get(characterIndex);

                // 그리고 그 타겟몬스터가 저장되어 있는 monster를 firstSkill로 공격
                gameCharacter.firstSkill(monster);
                // 일단 게임캐릭터가 아무 몬스터 타겟으로 정해서 firstSkill 실행

                // 루프 돌면서 몬스터 죽었는지 검사함
                for (int monsterIndex = 0; monsterIndex < monsterList.size(); monsterIndex++) {
                    final Monster selectedMonster = monsterList.get(monsterIndex);
                    // 캐릭터가 몬스터 팼으니까 몬스터 상태 가져옴
                    if (selectedMonster.getHp() <= 0 ) {
                        selectedMonster.setStatus(selectedMonster.DEATH); // 죽었다는 걸 알려줌
                        // final int targetMonsterIndex = CustomRandom.generateNumber(MONSTER_NUMBER - 1); 랜덤타겟을 가져올 때
                        // 죽은 애애 대해서는 타겟을 못하게 해야함 -> boolean (아직 몬스터 죽은거만)
                    }
                }
            }

            System.out.println(monsterList); // 게임캐릭터가 공격했으니 몬스터의 데미지를 확인해야

            // 이제 몬스터의 공격 (게임캐릭터와 매우 비슷함을 보임)
            for (int monsterIndex = 0; monsterIndex < monsterList.size(); monsterIndex++) {
                final Monster monster = new Monster();
                final int targetCharacterIndex = CustomRandom.generateNumber(CHARACTER_NUMBER-1);
                final GameCharacter gameCharacter = gameCharacterList.get(targetCharacterIndex);

                monster.firstSkill(gameCharacter);
            }

            System.out.println(gameCharacterList);
            // 여기까지 각자 firstSkill까지 썼고 이제 죽는거 보여줘야함
            // - 게임캐릭터 클래스와 몬스터 클래스에서 Death 만들어주기
            // - 그리고 죽었는지 다쳤는지의 상태를 보여주기 위해 status 변수도 생성

            Thread.sleep(1000); // 이것 때문에 메소드 이름에
            // throws InterruptedException 붙임
            // 1초마다 대기 걸 수 있음 - 1초마다 라운드 바뀌는 것 확인
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
