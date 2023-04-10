package homework.sixth.practice;

public class DiceGame {
    public DiceGame(){}

    // 세번째 숫자 판별
    public Player playDiceGame(Player player1, Player player2) {
        // 첫번째 사람이 게임 진행
        Score playerOneScore = player1.getScore();

        int firstScore = player1.rollDice();
        playerOneScore.add(firstScore);

        // 첫번째 주사위 검증
        if(firstScore % 2 == 1){
            return player1;
            // --> 홀수이면 더이상 다른 주사위 안 던지는데 return을 해버려서 얘가 이기게 됨
        }

        int secondScore = player1.rollDice();
        playerOneScore.add(secondScore);

        int thirdScore = player1.rollDice();
        playerOneScore.add(thirdScore);

        // 두번째 사람이 게임 진행
        Score playerOneScore2 = player2.getScore();

        int firstScore2 = player2.rollDice();
        playerOneScore2.add(firstScore2);

        // 첫번째 주사위 검증
        if(firstScore2 % 2 == 1){
            return player2;
            // --> 홀수이면 더이상 다른 주사위 안 던지는데 return을 해버려서 얘가 이기게 됨
        }

        int secondScore2 = player2.rollDice();
        playerOneScore2.add(secondScore2);

        int thirdScore2 = player2.rollDice();
        playerOneScore2.add(thirdScore2);

        // 세번째 점수로 점수 게임
        // .. 작성해야함

        // 점수 비교해 승자 반환
        if(playerOneScore.getTotalAmount() < playerOneScore2.getTotalAmount()){
            return player2;
        }
        return player1;
    }
}
