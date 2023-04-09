package test.dice3;

import test.componont.GameDice;
import test.componont.GameScore;
import test.componont.Player;

// 친구 < - 추후 다수의 Player로 확장가능성이 존재
// 주사위
// 점수
// 게임
class ThirdDiceGame {
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public ThirdDiceGame() {
        for(int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerArray[i]);
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편찾기 (1:1상황) targetPlayerIndex = 상대방, currentPlayerIndex = 나
        int targetPlayerIndex = 0;     // 타겟플레이어를 0으로 설정

        if (currentPlayerIndex == 0) { // 만약 최근 플레이어가 0이라면 타겟플레이어는 1
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;
    }

    // 아래 코드는 playerIndex로 지정된 플레이어의 3번째 게임 주사위의 값
    // 또는 해당 플레이어가 3번째 게임 주사위를 가지고 있지 않은 경우 0으로 만들어주는 코드
    public int findSpecialDiceNumber (int playerIndex) {
        //이부분에서 3번째 주사위라는것을 명시하는것
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;     // SPECIAL_DICE_INDEX를 숫자 2로 만들어주기 위해
                                                           // ARRAY_BIAS를 일부로 만들어서 2를 표현
                                                           // 인덱스이기 때문에 세 번째 주사위를 가리킴

        GameDice currentPlayerSpecialDice = playerArray[playerIndex].getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) {return 0;}  // null이면 0을 반환

        // 0이 아닌 값이 존재한다면 숫자를 확보
        int currentPlayerSpecialDiceNumber = currentPlayerSpecialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber; // 해당값을 출력해서 전달함
    }

    // 게임시작
    public void playGame() { // 세 번째 주사위의 기능
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;    // 1인경우 3점을 뺐음
        final int BUFF_SCORE = 2;     // 3인경우 2점을 얻음
        final int DEATH_SCORE = -1;   // 4인경우 1점을 빼았김

        // 세 번째 주사위 숫자를 가져와서 currentPlayerSpecialDiceNumber에 할당
        // 만약 currentPlayerSpecialDiceNumber == 0이라면 건너뛴다.
        // 플레이어1과 플레이어2를 차례로 확인.
        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) {continue;}

            int targetPlayerIndex = findTargetPlayerIndex(i);  // 플레이어를 찾아게임 점수를 가져오는 기능 수행

            // 상대방의 GameScore를 가져와서
            // targetPlayerScore 변수에 할당
            GameScore targetPlayerScore = playerArray[targetPlayerIndex].getGameScore();

            // 자신의 GameScore를 확보
            GameScore currentPlayerScore = playerArray[i].getGameScore();

            switch (currentPlayerSpecialDiceNumber) { // 이 부분은 GameScore를 통해 정리됌
                case STEAL:
                    // 내 점수에 상대방 점수 훔치기
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;

                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerArray[i]);
        }
    } // 모든 플레이어의 정보가 출력

    public void checkWinner() {
        // 각자의 점수 객체확보
        GameScore firstPlayerScore = playerArray[0].getGameScore();
        GameScore secondPlayerScore = playerArray[1].getGameScore();

        /* 승자 판정할 때 Player의 점수를 얻기 위한 목적으로 getter 가 필요합니다.
           고로 전체를 설계하고 쭉 진행한다는 개념 보다는
           정말 필요한가 ? 라고 한 번 묻고 필요하다면 사용하는 방식이 좋습니다. */
        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray[0].getName());
        } else {
            System.out.println("승자: " + playerArray[1].getName());
        }   // totalScore의 크기에 따라 승자를 출력
    }
}

public class Dice3 {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame();
        System.out.println("점수 판정 이후");
        game.printResult();
        game.playGame();
        game.checkWinner();
    }

}
