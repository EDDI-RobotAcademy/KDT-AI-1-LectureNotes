package writerForm.diceGame;

public class DiceGame {
    final private int DICE_MAX_NUM = 3;
    final private DiceDice[] dice = new DiceDice[DICE_MAX_NUM]; // 주사위 만들자 !
    final private DiceScore diceScore = new DiceScore();

    public DiceGame(){
    }

    public DicePlayer gamePlay(DicePlayer player1, DicePlayer player2) {
        // 주사위 3개의 배열 생성 후 0으로 초기화
        for(int i = 0; i < DICE_MAX_NUM; i++){
            dice[i] = new DiceDice();
            dice[i].setRandomDice(0);
        }

        // 주사위 3개 굴리기
        for(int i = 0; i < DICE_MAX_NUM; i++){
            dice[i].rollDie();

            // 주사위 첫 번째 수가 홀수이면 나가라
            if(dice[0].getRandomDice() % 2 == 1) {
                // 주사위 총합 구해라
                diceScore.setTotalScore(dice[0].getRandomDice());
                System.out.println("주사위"+(i+1)+": "+dice[i].getRandomDice());
                break;
            }

            // 주사위 총합 구해라
            diceScore.setTotalScore(dice[i].getRandomDice());
            System.out.println("주사위"+(i+1)+": "+dice[i].getRandomDice());
        }

        System.out.println("총합: "+diceScore.getTotalScore());

        // 주사위 세 번째 번호를 가지고, 총합 점수를 연산하라.
        if(dice[DICE_MAX_NUM-1].getRandomDice() == 1){
            //diceScore
        }

        // 총합 점수를 사용자에게 넘겨주어라
        player1.setPlayerTotalScore(diceScore.getTotalScore());

        return player1;
    }

    public DicePlayer winner(DicePlayer player1, DicePlayer player2) {
        if(player1.getPlayerTotalScore() > player2.getPlayerTotalScore()){
            return player1;
        }
        return player2;
    }

}
