package homework.diceThirdGame;

public class DiceGame {
    final private DicePlayer player1 = new DicePlayer("Cat"); //게임을 하려면 사용자가 2명 필요함
    final private DicePlayer player2 = new DicePlayer("Dog");
    private int totalScore1 = 0;
    private int totalScore2 = 0;
    private int[] diceArray1;
    private int[] diceArray2;
    final private int DICE_MAX_NUM = 3;

    public DiceGame(){
        diceArray1 = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
        diceArray2 = new int[DICE_MAX_NUM];
    }

    public void gamePlay() {
        final int ODD = 1;
        final int CONDITION_NUM = 2;
        final int FIRST_CHECK_NUMBER = 0;

        //플레이어 1
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray1[i] = player1.rollDice(i);

            // 총 합계
            //(1) 각 점수를 플레이어 객체가 점수 객체에게 전달해서 반환 값을 줘 !
            totalScore1 = player1.addScore(diceArray1[i]);

            if(diceArray1[FIRST_CHECK_NUMBER] % CONDITION_NUM == ODD){
                break;
            }
        }

        //플레이어 2
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray2[i] = player2.rollDice(i);

            // 총 합계
            totalScore2 = player2.addScore(diceArray2[i]);

            if(diceArray2[FIRST_CHECK_NUMBER] % CONDITION_NUM == ODD){
                break;
            }
        }

        System.out.println("player1: "+player1);
        System.out.println("player2: "+player2);

        // ★ 이렇게 되면 어떤 기준으로 표적이 되고, 공격자가 되는지 ..? 모르겠다
        thirdDiceCheck(player1, player2); // <- 하지만 일단 호출
    }

    // ★ --> 여기부터 다시 풀어보기
    public void thirdDiceCheck(DicePlayer target, DicePlayer attacker){
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        // 사용자의 주사위 마지막 것을 가져와라

        // target
        if(target == player1){
            if(diceArray1[DICE_MAX_NUM-1] == STEAL){
                // 근데 위의 텍스트 대로는 안되고, 그냥 diceArray[] 전역 변수를 가지고 오게 됨
                target.getDiceGameScore().setSteal(3);
                attacker.getDiceGameScore().loseSteal(3);
            }

            if(diceArray1[DICE_MAX_NUM-1] == BUFF){
                target.getDiceGameScore().setBuff(2);
            }

            if(diceArray1[DICE_MAX_NUM-1] == DEATH){
                target.getDiceGameScore().setTotalScore(-777);
            }
        }

        // attacker
        if(attacker == player2){
            if(diceArray2[DICE_MAX_NUM-1] == STEAL){
                // 근데 위의 텍스트 대로는 안되고, 그냥 diceArray[] 전역 변수를 가지고 오게 됨
                attacker.getDiceGameScore().setSteal(3);
                target.getDiceGameScore().loseSteal(3);
            }

            if(diceArray2[DICE_MAX_NUM-1] == BUFF){
                attacker.getDiceGameScore().setBuff(2);
            }

            if(diceArray2[DICE_MAX_NUM-1] == DEATH){
                attacker.getDiceGameScore().setTotalScore(-777);
            }
        }
    }

    public DicePlayer winner(DicePlayer player1, DicePlayer player2) {
        int playerOneResult = player1.getDiceGameScore().getTotalScore();
        int playerTwoResult = player2.getDiceGameScore().getTotalScore();

        if(playerOneResult > playerTwoResult){
            return player1;
        }
        return player2;
    }

    public DicePlayer getPlayer1() {
        return player1;
    }

    public DicePlayer getPlayer2() {
        return player2;
    }
    // ★ --> 여기까지 다시 풀어야 하는 부분
}
