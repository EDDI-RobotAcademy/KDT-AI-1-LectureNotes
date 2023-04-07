package homework.sixth.main;

import homework.sixth.component.GameScore;
import homework.sixth.component.Player;

import java.util.ArrayList;
import java.util.List;

class FourthDiceGame{

    final int PLAYER_NUM = 2;
    List<Player> players = new ArrayList<>();

    public FourthDiceGame(){
        for(int i=0; i<PLAYER_NUM; i++){
            players.add(new Player("플레이어"+(i+1)));
        }
    }

    public void calculateFinalScore(){

        for(int i=0; i<PLAYER_NUM; i++){
            int currentPlayerSpecialNumber = getThirdDiceNumber(i);

            if(currentPlayerSpecialNumber == 0){
                continue;
            }

            int targetPlayerIndex = findTarget(i);

            calculateScore(i, targetPlayerIndex, currentPlayerSpecialNumber);
        }
    }

    private int getThirdDiceNumber(int index) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        return players.get(index).getGameDices().get(SPECIAL_DICE_INDEX).getDiceNumber();
    }

    private int findTarget(int index){
        int targetPlayerIndex = 0;
        if(index==0){
            targetPlayerIndex = 1;
        }
        return targetPlayerIndex;
    }

    private void calculateScore(int index, int targetPlayerIndex, int currentPlayerSpecialNumber){

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        GameScore currentPlayerScore = players.get(index).getGameScore();
        GameScore targetPlayerScore = players.get(targetPlayerIndex).getGameScore();

        switch (currentPlayerSpecialNumber) {
            case STEAL:
                currentPlayerScore.stealScore(targetPlayerScore, STEAL_SCORE);
                break;

            case BUFF:
                currentPlayerScore.buffScore(BUFF_SCORE);
                break;

            case DEATH:
                currentPlayerScore.deathScore(DEATH_SCORE);
                break;
        }

    }

    public void chkWin(){
        GameScore player1Score = players.get(0).getGameScore();
        GameScore player2Score = players.get(1).getGameScore();

        if(player1Score.getTotalScore() > player2Score.getTotalScore())
            System.out.println(players.get(0).getName() + " 승리");
        else if(player1Score.getTotalScore() < player2Score.getTotalScore())
            System.out.println(players.get(1).getName() + " 승리");
        else
            System.out.println("비겼습니다");
            
    }

    public void print(){
        for(int i=0; i<PLAYER_NUM; i++){
            System.out.println(players.get(i).getName() + "의 주사위 값 : " + players.get(i).getGameDices()
                    + ", 점수 : " + players.get(i).getDiceNumber() + ", 최종 점수 : " + players.get(i).getGameScore().getTotalScore());
        }
    }

}
public class DiceGameFourthTest {
    public static void main(String[] args) {
        FourthDiceGame fourthDiceGame = new FourthDiceGame();

        fourthDiceGame.calculateFinalScore();
        fourthDiceGame.print();
        fourthDiceGame.chkWin();
    }
}
