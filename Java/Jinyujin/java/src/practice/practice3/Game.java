package practice.practice3;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // 플레이어 두명의 주사위 합산 값을 확인
    private List<Player> playerList = new ArrayList<>();
    final private int PLAYER_COUNT = 2;
    final private int HAVE_THIRD_DICE = 3;
    final int LIST_BIAS = 1;
    final int SPECIAL_DICE_INDEX = 3;

    public Game() {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            playerList.add(new Player("플레이어" + (i+1)));
            System.out.println(playerList.get(i));
        }
    }

    public int findThirdDiceNumber (int playerIndex) {
        // 먼저 세 번째 주사위 던졌는지 물어보기
        // diceList의 사이즈 확인하기

        List<Dice> diceList = playerList.get(playerIndex).getDiceList();

        if (diceList != null && playerList.get(playerIndex).getDiceList().size() ==
                HAVE_THIRD_DICE) {
            // 위 코드가 null 인 경우 IndexOutOfBoundsException 오류 발생
            // diceList != null 추가하여 해결

            int thirdDiceNumber = playerList.get(playerIndex).getDiceList().get(
                    SPECIAL_DICE_INDEX - LIST_BIAS).diceNumber2;
            return thirdDiceNumber;
        }
        return 0;
        // for 문은 오히려 복잡
        // get(0) -> 0이 들어갔다 = index를 사용했다 - index를 사용할 수 있겠다 생각할 것
    }

    // 세 번째 주사위 특성 입력
    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -999; // 무조건 패배를 위한 숫자 부여

        for (int i = 0; i < PLAYER_COUNT; i++) {

            int currentPlayerIndex = findThirdDiceNumber(i);
            int opponentPlayerIndex = (currentPlayerIndex + 1) % PLAYER_COUNT;
            // IndexOutOfBoundsException 에러 발생
            // 리스트형 객체에서 선언되지 않은 요소를 get하는 경우
            // int opponentPlayerIndex = (currentPlayerIndex + 1) % PLAYER_COUNT;
            // 로 검색하여 해결
            // 상대방 인덱스는 현재 플레이어 인덱스에 1을 더하고 그것을 플레이어 수만큼 나누어 주어야 함
            // 왜?

            if (findThirdDiceNumber(i) == BUFF) {
                playerList.get(i).getScore().setTotalScore(
                        playerList.get(i).getScore().getTotalScore() + BUFF_SCORE);
                //totalScore += totalScore + 2
                // i번째 플레이어의 스코어의 토탈스코어에
                // i번째 플레이어의 스코어의 토탈스코어를 가져와서 2를 더해줘라
            }
            if (findThirdDiceNumber(i) == DEATH) {
                playerList.get(i).getScore().setTotalScore(DEATH_SCORE);
            }
            if (findThirdDiceNumber(i) == STEAL) { // 세 번째 주사위의 수가 1이라면

                Player opponentPlayer = playerList.get(opponentPlayerIndex);
                Player currentPlayer = playerList.get(currentPlayerIndex);

                // 현재 플레이어의 스코어 클래스의 토탈스코어를 설정해라
                // 상대방 플레이어의 주사위 숫자합에 3점 뺏기
                // 현재 플레이어의 주사위 숫자합에 3점 추가
                //playerList.get(opponentPlayerIndex).getScore().setTotalScore(
                //        playerList.get(currentPlayerIndex).getDiceSum() - STEAL_SCORE);

                currentPlayer.getScore().setTotalScore(currentPlayer.getDiceSum() + STEAL_SCORE);
                // 현재 플레이어의 스코어의 토탈스코어를 설정해라
                // 현재 플레이어의 주사위 합에 3을 더해서
                opponentPlayer.getScore().setTotalScore(opponentPlayer.getDiceSum() - STEAL_SCORE);
                // 상대 플레이어의 스코어의 토탈스코어를 설정해라
                // 상대 플레이어의 주사위 합에 3을 빼서

            }
        }
    }


    public void findResult() {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {
        Score firstPlayerScore = playerList.get(0).getScore();
        Score secondPlayerScore = playerList.get(1).getScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerList.get(0).getName());
        } else {
            System.out.println("승자: " + playerList.get(1).getName());
        }
    }
}
