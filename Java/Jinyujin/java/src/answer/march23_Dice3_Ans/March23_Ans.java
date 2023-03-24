package answer.march23_Dice3_Ans;

// 친구 <- 추후 다수의 Player로 확장 가능성이 존재
// 주사위
// 점수
// 게임
// 지금 당장해야 하는 것에 집중! 그러다보면 뭘 구현해야 할지 생긴다
// 모르겠는 질문은 그냥 막 던지기 OK!!!

class ThirdDiceGame {
    // 일단 player 클래스에서 player만 만든 상태
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1)); // player 클래스로 넘어가서 tostring 생성
            System.out.println(playerArray[i]);
        }
        // 여기까지 만들었을 때 player 2명 나타난걸 알 수 있다
        // 그리고 뭘 만들고 싶을까? -> game시작하겠다
    }

    private int findThirdPlayerIndex (int currenPlayerIndex) {
        int targetPlayerIndex = 0;

        if (currenPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        GameDice currentPlayerSpecialDice =
                playerArray[playerIndex].getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) { return 0; }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        // 게임을 하려면? 주사위 필요
        // 주사위는 누가 갖고 있는게 나을까? public ThirdDiceGame() 혹은 player?
        // 모르겠으면 일단 다 넣어보자 (큰 상관 없다고 함)

        // 세번째 주사위에 대한 정보 세팅
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기에 대한 전략 필요 (1:1 상황)
            int targetPlayerIndex = findThirdPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerArray[targetPlayerIndex].getGameScore(); // 아 점수가 필요하네 -> player 클래스 가서 만들자

            GameScore currentPlayerScore =
                    playerArray[i].getGameScore();

            switch (currentPlayerSpecialDiceNumber){
                case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE); // 같은 score끼리 연산하도록
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
     public void checkWinner() {
        //TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대 시 리팩토링 필요
         GameScore firstPlayerScore = playerArray[0].getGameScore();
         GameScore secondPlayerScore = playerArray[1].getGameScore();

         if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
             System.out.println("승자: " + playerArray[0].getName());
         } else {
             System.out.println("승자: " + playerArray[1].getName());
         }
     }
}
public class March23_Ans {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame(); // 게임이 만들어지면서 게임을 플레이하는데 필요한 정보 세팅
        System.out.println("점수 판정 이후");
        // 한번에 다 구성하는게 아니라 선별적으로 세팅!
        game.playGame(); // -> 먼저 이걸 만들고나면 playGame 메소드를 만들어야 겠다고 생각
        game.printResult();
        game.checkWinner();
    }
}
