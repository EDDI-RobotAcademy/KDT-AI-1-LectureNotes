package DiceGame.Player;

// 친구 <- 추후 다수의 Player로 확장 가능성이 존재
// 주사위
// 점수
// 게임
class GameMainT {

    final private int PLAYER_NUM = 2;   // 플레이어

    // 플레이어를 배열을 이용하여 만듬 (0, 1)
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public void GameMain() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            // 플레이어 0, 1             // i에 1을 더하여 1, 2로 표현
            playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerArray[i]);
        }
    }

    private int findTargetPlayerIndex(int currentPlayerIndex) {

        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex = 0;

        // currentPlayerIndex 같으면 0, targetPlayerIndex 1
        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;
    }

    // 특수한 주사위 찾는 함수
    private int findSpecialDiceNumber(int playerIndex) {
        // ARRAY_BIAS : 배열 0부터 시작하기 때문에 보는 관점에서 불일치가 발생하므로
        // 편향 값인 1을 강제해서 관점을 일치시키는 작업
        // 내부에서 알아서 편향치인 1을 빼서 [2]로 처리
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS; // 0 ~ 2
        /*
        final int SPECIAL_DICE_INDEX = 2 와 같은 것
        */

        // 내 특수한 주사위
        GameDice currentPlayerSpecialDice =
                playerArray[playerIndex].getSelectedGameDice(SPECIAL_DICE_INDEX);

        // 내 특수한 주사위가  null 이면 0
        if (currentPlayerSpecialDice == null) {
            return 0;
        }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();   // 랜덤으로 만든 값의 정보를 가져옴

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        final int STEAL = 1; // 주사위 1 나오면
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3; // 3점을 가져옴
        final int BUFF_SCORE = 2; // 2점 받음
        final int DEATH_SCORE = -1; // -1이 됨

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            // currentPlayerSpecialDiceNumber 안나올 경우 건너뛴다
            if (currentPlayerSpecialDiceNumber == 0) {
                continue;
            }

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerArray[targetPlayerIndex].getGameScore();

            GameScore currentPlayerScore =
                    playerArray[i].getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                // 1이 나오면 takeScore
                case STEAL:
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
    }


    // 승자 판정
    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        GameScore firstPlayerScore = playerArray[0].getGameScore();
        GameScore secondPlayerScore = playerArray[1].getGameScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray[0].getName());
        } else {
            System.out.println("승자: " + playerArray[1].getName());
        }
    }
}



    class GameMain {
        public static void main(String[] args) {
            GameMainT game = new GameMainT();
            System.out.println("점수 판정 이후");
            game.playGame();
            game.printResult();
            game.checkWinner();
        }

    }
