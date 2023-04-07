package game.rpg.controller;

import game.rpg.characterModel.RefactorGameCharacter;
import game.rpg.characterModel.RefactorMonster;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorGameManager {
    // 가장 디폴트한 캐릭터 모델 클래스 필요
    // -> 게임캐릭터와 몬스터의 공통 요소 가져가기

    private List<RefactorMonster> monsterList;
    private List<RefactorGameCharacter> characterList;
    // 몬스터와 게임캐릭터는 개체 수가 바뀔 수 있기에 final 박지 않음

    final int MONSTER_MAX_NUMBER = 2;
    final int CHARACTER_MAX_NUMBER = 3;
    final int ATTACKER_IS_PLAYER = 333;
    final int ATTACKER_IS_MONSTER = 777;

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
                    MONSTER_STAT_MIN, MONSTER_STAT_MAX, MONSTER_HP_MIN, MONSTER_HP_MAX);
            // 리팩터몬스터에 있는 super함수를 참조하도록 하는 코드
            // - 결국 캐릭터 모델에서 상속받은 속성들을 이용
            // 일단 몬스터리스트를 생성하기 위해 for문을 돌리는 것
            // monster 객체 생성 -> 리팩터몬스터의 생성자를 이용하여 저장할 수 있음
            // RefactorMonster 클래스의 super함수가 캐릭터모델을 상속받고 있으니 힘, 민첩함 등의 정보 가져올 수 있음
            // 그리고 매개변수 위치 잘 지켜줘야 한다
            // 쓴 순서대로 인식하나봄

            monsterList.add(monster);
        }

        for (int i = 0; i < CHARACTER_MAX_NUMBER; i++) {
            final RefactorGameCharacter playCharacter = new RefactorGameCharacter(
                    PLAYER_STAT_MIN, PLAYER_STAT_MAX, PLAYER_HP_MIN, PLAYER_HP_MAX);
            // 얘도 마찬가지

            characterList.add(playCharacter);
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 1;

        for (; ; turn++) { // 무한으로 턴이 하나씩 늘어난다
            System.out.println("현재 턴: " + turn); // 턴 수 출력까지 완료 -> 이제 게임 시작

            // 게임: 플레이어가 몬스터 때려죽이기, 몬스터도 플레이어 죽일 수 있음
            // 일단 플레이어의 선공 - for 문

            playerTurnBehavior(); // Ctrl + Alt + M
            // 지저분해 보이기에 따로 빼서 메소드로 정리해둠
            // 그럼 여기까지 봤을 때 무한루프 돌면서 턴을 반복하는구나
            // 그리고 플레이어 턴에 뭔가를 하는구나 라는 내용이 전달된다

//            printBattleInfo(); // 플레이어 턴에 어떤 행동을 하고 배틀에 대한 정보를 출력할 수 있구나

            // 여기까지 일방적으로 플레이어가 몬스터를 공격하는 상황
            // 몬스터의 hp가 다 달았음에도 계속 공격할 수 있기에 몬스터가 죽으면 게임을 끝낼 수 있도록 해야함
            // 몬스터가 죽었는지 살았는지 판정해야 함 -> if 문으로

            // if 몬스터의 hp가 0보다 작거나 같아면 status를 -999로 설정해라
            // 여기서 enum을 사용해야 할 것 같음 - 상태를 표현하기 위해서
            // (enum은 패턴을 더 간단하게 사용하기 위한 것이었음) - 완료

            // 이제 if 문으로 몬스터 죽는 것 추가할 것
            // 몬스터가 죽으면 플레이어가 할 행동이 없어져 게임이 끝나야 함
            // 그런데 생각해야 할 것은 몬스터만 공격 당하고 죽는 것이 아니라
            // 플레이어도 공격 당하고 죽을 수 있음
            // 그래서 플레이어나 몬스터의 개체 수가 변경 될 수 있다는 것 때문에 넘버말고 리스트로 설정
            // -> playerTurnBehavior() 메서드의 for문의 조건 수정: CHARACTER_MAX_NUMBER -> characterList.size()
            // 또한 몬스터를 랜덤 하나씩 뽑아오는 수도 리스트로 설정
            // -> playerTurnBehavior() 메서드는 결론적으로 불리언을 리턴해야 함
            // 몬스터가 죽으면 그만 때리게 해야 하니까

//            final boolean isAllMonsterKilled = playerTurnBehavior();
            // isAllMonsterKilled라는 이름의 boolean 변수에
            // playerTurnBehavior() 메서드의 반환값을 저장해라(Boolean 형식임)
            // isAllMonsterKilled 변수는 playerTurnBehavior() 메서드의 반환값에 따라
            // true 혹은 false의 값을 가지게 된다
//            if (isAllMonsterKilled) { // isAllMonsterKilled 가 트루라면
//                                      // = playerTurnBehavior() 메서드에서 몬스터가 다 죽었다면 true(KilledAllMonster)
//                                      // 몬스터가 다 죽지 않았다면 false 값을 받을 것
//                System.out.println("플레이어 승리!");
//                break; // 플레이어 승리하면 루프 빠져나오니까 break 걸어줌
//            }
            // 지금까지 플레이어 공격으로 몬스터가 죽었는지 안 죽었는지의 상황
            // 이제 똑같은 방식으로 몬스터 공격에 플레이어 죽는지 안죽는지 보자

            monsterTurnBehavior(); // 몬스터 공격

            final boolean isAllPlayerKilled = monsterTurnBehavior();
            if (isAllPlayerKilled) {
                System.out.println("플레이어 패배!");
                break;
            }

            // 그런데 여전히 맘에 안드는 부분은 플레이어와 몬스터가 하는 일이 중복된 코드라는 것
            // 그래서 turnBehavior(); 형식으로 선언하고 개릭터리스트와 몬스터 리스트를 추가하는 매개변수 추가
            final boolean isAllMonsterKilled = turnBehavior(
                    characterList, monsterList, ATTACKER_IS_PLAYER); // 위의 불리언 isAllMonsterKilled 주석 처리
            if (isAllMonsterKilled) {
                System.out.println("플레이어 승리!");
                break;
            }

            printBattleInfo(); // 결론적인건 실행한 후 아래에서 출력해줘야 함

            Thread.sleep(1000);
        }
    }

    private <T, U> boolean turnBehavior(List<T> attackerList, List<U> defenderList, int castingType) { // 제너릭 한 후에 해야함
        // 게임캐릭터와 몬스터에서 타게팅스킬 메서드 타입 바꿔줘야함

        Boolean isAllKilled = true;

        for (int attackerIdx = 0; attackerIdx < attackerList.size(); attackerIdx++) {

            final int defenderIdx = CustomRandom.generateNumber(defenderList.size() - 1);

            final T attacker = attackerList.get(attackerIdx);
            final U defender = defenderList.get(defenderIdx);

            // attacker.targetingSkill(defender);

//            if (attacker.decisionDeath()) {
//                defenderList.remove(defenderIdx);
//            }
//            if (defenderList.size() == 0) {
//                return isAllKilled;
//            }

            // 공격에 대한 if문
            if (castingType == ATTACKER_IS_PLAYER) {
                ((RefactorGameCharacter) attacker).targetingSkill(defender);
            } else {
                ((RefactorMonster) attacker).targetingSkill(defender);
            }

            // 죽음 판정에 대한 if문
            if (castingType == ATTACKER_IS_PLAYER) {
                if (((RefactorMonster) defender).decisionDeath()) {
                    defenderList.remove(defenderIdx);
                }
            } else {
                if (((RefactorGameCharacter) defender).decisionDeath()) {
                    defenderList.remove(defenderIdx);
                }
            }

            if (defenderList.size() == 0) {
                return isAllKilled;
            }
        }

        return false;
    }

        private Boolean playerTurnBehavior () {
            final Boolean killedAllMonster = true;

            for (int characterIdx = 0; characterIdx < characterList.size(); characterIdx++) {
                final RefactorGameCharacter character = characterList.get(characterIdx);

                int monsterIdx = CustomRandom.generateNumber(monsterList.size() - 1);
                final RefactorMonster monster = monsterList.get(monsterIdx);
                // 캐릭터 인덱스 하나하나씩 캐릭터 최대 수까지 공격한다 - 반복
                // character 객체 생성 - 캐릭터리스트에서 캐릭터인덱스를 가져와서 저장해줌
                // 이제 캐릭터가 스킬 쓸 꺼니까 대상인 몬스터 데려와야 함
                // monster 객체 생성 - 랜덤으로 몬스터를 데려와서 monster에 저장

                character.targetingSkill(monster);
                // 캐릭터 인덱스가 저장된 character로 랜덤으로 데려온 monster 타겟팅해서 공격
                // 스킬 인터페이스에 생성할 것
                // 임플먼츠까지 완료 - 이제 리팩터게임캐릭터 클래스에서 타겟팅 스킬 짜야함

                // 몬스터 죽었을 때의 판정 - if 문
                if (monster.decisionDeath()) {       // 몬스터가 죽었다면
                    monsterList.remove(monsterIdx);  // 몬스터 리스트에서 몬스터 인덱스를 제거해라
                }
                // 몬스터가 다 죽었다면 모든 몬스터가 죽었음을 반환해라
                if (monsterList.size() == 0) {
                    return killedAllMonster; // 그냥 true인데 명시적으로 다 죽었음을 보여주기 위함
                    // 위에 불리언 killedAllMonster = true 만들어줄 것
                }
            }
            return false;
        } // 결과적으로 이 메서드는 루프 돌면서 몬스터를 팸
        // 그래서 출력을 해보면 이 메서드는 결론적으로 불리언을 리턴해야함을 알 수 있다 - 왜?
        // 몬스터가 죽으면 그만 때려야 하니까

        private Boolean monsterTurnBehavior () {
            final Boolean KilledAllPlayer = true;

            for (int monsterIdx = 0; monsterIdx < monsterList.size(); monsterIdx++) {
                final RefactorMonster monster = monsterList.get(monsterIdx);

                final int characterIdx = CustomRandom.generateNumber(characterList.size() - 1);
                final RefactorGameCharacter character = characterList.get(characterIdx);

                monster.targetingSkill(character);

                if (character.decisionDeath()) {
                    characterList.remove(characterIdx);
                }
                if (characterList.size() == 0) {
                    return KilledAllPlayer;
                }
            }
            return false;
        }

        private void printBattleInfo () {
            // playerTurnBehavior() 메서드 진행하면 플레이어가 스킬을 사용
            // 그럼 게임 진행경과를 확인할 수 있음
            // 캐릭터 리스트와 몬스터 리스트 출력문 작성
//        System.out.println(characterList);
//        System.out.println(monsterList);
            // 이것도 지저분해 보인다면 따로 빼줄 수 있음 - 뺌

            // 여기서 더욱 확실하게 플레이어와 몬스터의 상태를 알려주기 위해 출력문 추가
            System.out.println("캐릭터 상태 정보: ");
            System.out.println(characterList);
            System.out.println(); // 엔터
            System.out.println("몬스터 상태 정보: ");
            System.out.println(monsterList);
        }



        @Override
        public String toString () {
            return "RefactorGameManager{" +
                    "monsterList=" + monsterList +
                    ", characterList=" + characterList +
                    '}';

    }
}
