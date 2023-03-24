package HomeWork.DiceGame.main;


import HomeWork.DiceGame.component.GameDice;
import HomeWork.DiceGame.component.GameScore;
import HomeWork.DiceGame.component.Player;

// 친구 <- 추후 다수의 Player로 확장 가능성이 존재
// 주사위
// 점수
// 게임
class ThirdDiceGame {
    final private int PLAYER_NUM = 2; // 플레이어 몇 명
    final private Player[] playerArray = new Player[PLAYER_NUM]; // 플레이어
    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerArray[i]);
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex = 0;

        // 내가 0번이면 상대방은 1번임 (1:1이니까)
        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber (int playerIndex) {
        // 특수 주사위는 3번째 주사위만 있으므로
        // 배열은 0부터 시작 하니까 마지막 index는 2에 해당한다.
        // 그래서 2 만들어 주기위해서 1을 빼줘야함
        final int ARRAY_BIAS = 1; // 그래서 bias 숫자를 만들었다.
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;
        // 특수 주사위 자리 = 3 - 1

        GameDice currentPlayerSpecialDice = playerArray[playerIndex].getSelectedGameDice(SPECIAL_DICE_INDEX);
        // 플레이어 정보에서 선택한 2번 index의 GameDice 객체를 확보함

        // 현재 플레이어
        // 만약 null을 가져왔다면 없으므로 0점을 리턴
        if (currentPlayerSpecialDice == null) { return 0; }

        // 값이 존재한다면 이 특수 주사위의 번호를 확보함
        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();


        // 해당 값을 출력해서 전달함
        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() { // @@@@@@@@@@@@@@@@@@@@@@@ 맨처음 실행 @@@@@@@@@@@@@@@@@@@@@

        final int STEAL = 1; // 뺏기 위한 조건
        final int BUFF = 3; // 얻기 위한 조건
        final int DEATH = 4; // 죽기 위한 조건

        final int STEAL_SCORE = 3; // 뺏을 점수
        final int BUFF_SCORE = 2; // 얻을 점수
        final int DEATH_SCORE = -1; // 죽었을 때 점수

        for (int i = 0; i < PLAYER_NUM; i++) {              // 플레이어 숫자 만큼 반복
            // 현재 사용자의 특수 주사위의 눈금을 확인한다.
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);


            if (currentPlayerSpecialDiceNumber == 0) { continue; }
            // 0이면 동작할 필요 없으니 이 플레이어를 제낌

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            // 상대방의 점수 객체를 확보함
            GameScore targetPlayerScore =
                    playerArray[targetPlayerIndex].getGameScore();

            // 자신의 점수 객체를 확보함
            GameScore currentPlayerScore =
                    playerArray[i].getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL -> targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                case BUFF -> currentPlayerScore.addScore(BUFF_SCORE);
                case DEATH -> currentPlayerScore.loseAll(DEATH_SCORE);
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerArray[i]);
        }
    }

    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        GameScore firstPlayerScore = playerArray[0].getGameScore(); // 첫번째 플레이어 스코어는
        GameScore secondPlayerScore = playerArray[1].getGameScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray[0].getName());
        } else {
            System.out.println("승자: " + playerArray[1].getName());
        }
    }
}

public class DiceGameThirdTest {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame(); // 인스턴스 생성 및 생성자 호출
        System.out.println("점수 판정 이후");

        game.playGame(); // 게임플레이
        game.printResult();
        game.checkWinner();
    }
}