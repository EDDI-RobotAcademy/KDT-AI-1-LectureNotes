package homework.third;

import java.util.Arrays;

class Game3{
    final String player1, player2;
    final int player1_thirdDice, player2_thirdDice;
    final int player1_score, player2_score;
    int player1_resultScore , player2_resultScore;
    final int diceCount = 3;
    final int[] player1_diceArray = new int[diceCount];
    final int[] player2_diceArray = new int[diceCount];

    ValueCheck valueCheck = new ValueCheck();

    public Game3(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
        for(int i=0; i<diceCount; i++){
            player1_diceArray[i] = new Dice3().getRandomValue();

            if(valueCheck.evenCheck(player1_diceArray[0])) {
                System.out.println(player1 + "의 첫번째 주사위가 짝수가 아니기 때문에 더 이상 기회 없음");
                break;
            }
        }
        for(int i=0; i<diceCount; i++){
            player2_diceArray[i] = new Dice3().getRandomValue();

            if(valueCheck.evenCheck(player2_diceArray[0])) {
                System.out.println(player2 + "의 첫번째 주사위가 짝수가 아니기 때문에 더 이상 기회 없음");
                break;
            }
        }

        this.player1_thirdDice = player1_diceArray[player1_diceArray.length-1];
        this.player2_thirdDice = player2_diceArray[player2_diceArray.length-1];
        this.player1_score = new Score3(player1_diceArray).getTotalScore();
        this.player2_score = new Score3(player2_diceArray).getTotalScore();
    }

    public void resultScore(){
        UpdateScore updateScore = new UpdateScore(player1_score,player2_score,
                player1_thirdDice,player2_thirdDice);

        this.player1_resultScore = updateScore.getPlayer1_resultScore();
        this.player2_resultScore = updateScore.getPlayer2_resultScore();

        System.out.println(player1+ "의 최종 점수 = " + player1_resultScore
                + "," + player2 + "의 최종 점수 = " + player2_resultScore+"");

        }
    public void chk(){
        resultScore();
        valueCheck.thirdDiceCheck(player1_thirdDice,player1);
        valueCheck.thirdDiceCheck(player2_thirdDice,player2);

        if(player1_thirdDice == 4){
            System.out.println(player1 + " 패배");
            return;
        }
        if(player2_thirdDice == 4){
            System.out.println(player2 + "패배");
            return;
        }

        if(player1_resultScore > player2_resultScore){
            System.out.println(player1 + " 승리!");
        }
        if(player1_resultScore < player2_resultScore){
            System.out.println(player2 + " 승리!");
        }
        if(player1_resultScore == player2_resultScore){
            System.out.println("비겼습니다!");
        }
    }

    @Override
    public String toString() {
        return player1 + "의 주사위 값 = " + Arrays.toString(player1_diceArray)
                +", " + player2 + "의 주사위 값 = "+ Arrays.toString(player2_diceArray)
                + "\n" + player1 + "의 점수 = " + player1_score +
                "," + player2 + "의 점수 = " + player2_score;
    }
}

class Dice3{

    final int MIN = 1;
    final int MAX = 6;
    final int randomValue;

    public Dice3(){
        this.randomValue = (int)(Math.random() * (MAX - MIN + 1) + MIN);
    }

    public int getRandomValue() {
        return randomValue;
    }
}

class Score3{
    final int totalScore;
    int tmpScore;
    public Score3(int[] diceArray){
        for (int value : diceArray) {
            tmpScore += value;
        }

        this.totalScore = tmpScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}

class ValueCheck{

    final int thirdDice;
    int tmpValue = 0;

    public boolean evenCheck(int value){
        return value % 2 != 0;
    }

    public ValueCheck(){
        this.thirdDice = tmpValue;
    }

    public void thirdDiceCheck(int thirdDice, String player) {
        if(thirdDice == 1){
            System.out.println(player + "의 세번째 주사위 1이 나와서 상대방 점수 3점 빼았음");
            tmpValue = thirdDice;
        }
        if(thirdDice == 3){
            System.out.println(player + "의 세번째 주사위 3이 나와서 내 점수 2점 가점");
            tmpValue = thirdDice;
        }
        if(thirdDice == 4){
            System.out.println(player + "의 세번째 주사위 4가 나와서 패배");
            tmpValue = thirdDice;
        }
    }
}

class UpdateScore{
    final int player1_resultScore;
    final int player2_resultScore;
    public UpdateScore(int player1_score, int player2_score, int player1_thirdDice, int player2_thirdDice){

        if(player1_thirdDice == 1){
            player1_score += 3;
            player2_score -= 3;
        }
        if(player1_thirdDice == 3){
            player1_score += 2;
        }

        if(player2_thirdDice == 1){
            player1_score -= 3;
            player2_score += 3;
        }
        if(player2_thirdDice == 3){
            player2_score += 2;
        }

        this.player1_resultScore = player1_score;
        this.player2_resultScore = player2_score;
    }

    public int getPlayer1_resultScore() {
        return player1_resultScore;
    }
    public int getPlayer2_resultScore() {
        return player2_resultScore;
    }
}
public class DiceClassQuizThird {
    public static void main(String[] args) {
        Game3 game3 = new Game3("김","박");

        System.out.println(game3);
        game3.chk();
    }
}