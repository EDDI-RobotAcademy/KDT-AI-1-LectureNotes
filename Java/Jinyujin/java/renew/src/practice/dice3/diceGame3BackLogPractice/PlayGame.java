package practice.dice3.diceGame3BackLogPractice;

import java.util.ArrayList;
import java.util.List;

// 세 번째 주사위 규칙 적용하기
public class PlayGame {

    final private List<Player> playerList = new ArrayList<>();
    final private int PLAYER_COUNT = 2;

    // 플레이어 수 설정
    public PlayGame() {

        for (int i = 0; i < PLAYER_COUNT; i++) {
            playerList.add(new Player("플레이어" + (i+1)));
            System.out.println(playerList.get(i));
        }
    }

    // 세 번째 주사위에 대한 조건은 내 주사위 숫자가 뭔지 알 수 있어야 함
    // 그리고 내 주사위 합과 상대 주사위 합도 알아야 함
    // 그리고 조건을 적용한 최종 점수도 알 수 있어야 함

    // 존나 어렵다2
    // 이 부분 이해 못함
    public int findThirdDiceNumber(int playerIdx) {

        // 세 번째 주사위를 찾기 위함
        // 플레이어리스트가 주사위 3개를 돌리니까 플레이어리스트의 2번째가 세 번째 주사위
        // 그 수를 찾으면 됨
        final int LIST_BIAS = 1;
        final int THIRD_DICE_INDEX = 3 - LIST_BIAS;

        // 현재 플레이어의 세 번째 주사위 선언해주기
        Dice currentPlayerThirdDice = playerList.get(playerIdx).needToSelectDice(THIRD_DICE_INDEX);
        // 이 부분에서 두 번째 인덱스를 무조건 획득하게 함
        // 2번 인덱스가 없는 상황에서도 획득하려고 하기 때문에 IndexOutOfBoundsException 오류가 발생

        if (currentPlayerThirdDice == null) {
            return 0;
        }

        // 현재 플레이어이 세 번째 주사위 숫자 찾아주기
        int currentPlayerThirdDiceNumber = currentPlayerThirdDice.getDiceNumber();

        return currentPlayerThirdDiceNumber;
    }

    // 현재 플레이어와 상대 플레이어의 점수를 알기 위해 플레이어들의 index를 알아야 함
    public int findOpponentPlayerIdx(int currentPlayerIdx) {

        int opponentPlayerIdx = 0;

        if (currentPlayerIdx == 0) {
            opponentPlayerIdx = 1;
        }
        return opponentPlayerIdx;
    }

    // 이제 세 번째 주사위를 조건으로 돌릴 수 있어야 함
    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -777;

        for (int i = 0; i < PLAYER_COUNT; i++) {

            int currentPlayerThirdDiceNumber = findThirdDiceNumber(i);
            // 위의 메서드에서 만들어 놓은 currentPlayerThirdDiceNumber를 일단 int로 설정하고
            // findThirdDiceNumber메서드를 이용하여 currentPlayerThirdDiceNumber이 반환되도록 설정!

            if (currentPlayerThirdDiceNumber == 0) {
                continue;
            }

            int opponentPlayerIdx = findOpponentPlayerIdx(i);
            // 상대 플레이어의 인덱스를 구하기 위해 findOpponentPlayer메서드를 이용
            // 그 메서드 내용은 만약 현재 플레이어 인덱스가 0이라면 상대 플레이어 인덱스가 1이라는 내용으로
            // 결국엔 상대 플레이어 인덱스를 반환해라는 것
            // 이 부분 이해 안감
            // i를 넣어서 opponentPlayerIdx가 0일 때 currentPlayerIdx가 1,
            // opponentPlayerIdx가 1일 때 currentPlayerIdx가 0 이런식으로 돌아가게 되어있음

            Score currentPlayerScore = playerList.get(i).getScore();
                    // 현재 플레이어의 점수니까 playerList를 이용하면 좋을 것 같음

            // 현재 플레이어 설정했으니 상대 플레이어 점수 설정
            Score opponentPlayerScore = playerList.get(opponentPlayerIdx).getScore();

            switch (currentPlayerThirdDiceNumber) {
                // 스위치 문 돌리려고 하니 플레이어들의 점수가 필요하다고 생각
                case STEAL:
                    opponentPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
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

    // 승자 판정 이후 플레이어의 정보를 나타내주기 위함
    public void nextThirdCondition() {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWin() {

        Score firstPlayerScore = playerList.get(0).getScore();
        Score secondPlayerScore = playerList.get(1).getScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승리: " + playerList.get(0).getName());
        } else {
            System.out.println("승리: " + playerList.get(1).getName());
        }
    }
}
