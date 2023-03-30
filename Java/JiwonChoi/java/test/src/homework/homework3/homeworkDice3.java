package homework.homework3;


import java.util.Arrays;

import static homework.homework3.gameSet.diceCount;
import static homework.homework3.gameSet.playersListSet;

class Player { //플레이어정보
    String playerName;
    int[] playerDices;
    int beforeScore;
    int finalScore;

    public Player(String playerName) { //플레이어 생성
        this.playerName = playerName;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public void setBeforeScore(int beforeScore) {
        this.beforeScore = beforeScore;
    }

    public int getBeforeScore() {
        return beforeScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int[] getPlayerDices() {
        return playerDices;
    }

    public void setPlayerDices(int[] playerDices) {
        this.playerDices = playerDices;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerDices=" + Arrays.toString(playerDices) +
                ", beforeScore=" + beforeScore +
                ", finalScore=" + finalScore +
                '}';
    }
}


class gameSet { //게임 세팅
    static final int diceCount = 3; //다이스는 총 3개
    static Player[] playersListSet = new Player[2];

    static void makePlayerList(Player _1p, Player _2p) {
        playersListSet[0] = _1p;
        playersListSet[1] = _2p;
    }

    public static void rollDice(Player player) { //주사위 굴리기
        int[] playerDices = new int[diceCount];
        for (int i = 0; i < diceCount; i++) {
            playerDices[i] = (int) (Math.random() * 6) + 1;
            player.setPlayerDices(playerDices); //[랜덤주사위1][랜덤주사위2][랜덤주사위3]플레이어 다이스배열 요소에 대입
        }

        if(playerDices[0] % 2 != 0){ //홀수면 [랜덤주사위1][0][0]
            playerDices[1] = 0;
            playerDices[2] = 0;
        }
    }
}

class Score{

    static void sumScore(Player player){
        int startScore = 0;
        for (int i =0; i < diceCount; i++) {
        startScore += player.playerDices[i];
        }
        player.setBeforeScore(startScore);
    }

    static void bonusScore(Player[] playersListSet){
        switch (playersListSet[0].playerDices[2]) { //플레이어1의 경우
            case 1 :
                int player1Dice1BonusScore = playersListSet[0].getBeforeScore() + 3;
                playersListSet[0].setFinalScore(player1Dice1BonusScore);

                int player2Dice1BonusScore = playersListSet[1].getBeforeScore() - 3;
                playersListSet[1].setFinalScore(player2Dice1BonusScore);

                playersListSet[1].setBeforeScore(player2Dice1BonusScore);
                break;

            case 3 :
                int player1Dice3BonusScore = playersListSet[0].getBeforeScore() + 2;
                playersListSet[0].setFinalScore(player1Dice3BonusScore);
                break;

            case 4 :
                int player1Dice4BonusScore = 0;
                playersListSet[0].setFinalScore(player1Dice4BonusScore);
                break;

            default :
                int player1DiceDefaultBonusScore = playersListSet[0].getBeforeScore();
                playersListSet[0].setFinalScore( player1DiceDefaultBonusScore);
                break;
        }

        switch (playersListSet[1].playerDices[2]) { //플레이어2의 경우
            case 1 :
                int player2Dice1BonusScore = playersListSet[1].getBeforeScore() + 3;
                playersListSet[1].setFinalScore(player2Dice1BonusScore);

                int player1Dice1BonusScore = playersListSet[0].getBeforeScore() - 3;
                playersListSet[0].setFinalScore(player1Dice1BonusScore);
                break;

            case 3 :
                int player2Dice3BonusScore = playersListSet[1].getBeforeScore() + 2;
                playersListSet[1].setFinalScore(player2Dice3BonusScore);
                break;

            case 4 :
                int player2Dice4BonusScore = 0;
                playersListSet[1].setFinalScore(player2Dice4BonusScore);
                break;

            default :
                int player2DiceDefaultBonusScore = playersListSet[1].getBeforeScore();
                playersListSet[1].setFinalScore( player2DiceDefaultBonusScore);
                break;
        }

//        System.out.println("플레이어1의 점수 = " + playersListSet[0].getFinalScore() +
//                '\n' +
//                "플레이어2의 점수 = " + playersListSet[1].getFinalScore() +
//                '\n');

    }



}


//class winnerCheck { //점수 더 높은사람이 win
//    public static String winnerName(String _1p, String _2p, int _1pScore, int _2pScore) { //이름1,이름2, 점수1, 점수2 입력
//        String winner;
//        if(_1pScore < -998) {               //주사위 4가 나왔을때 큰 숫자를 빼서 지도록..
//            winner = _2p + " 승리!(주사위 4)";
//        } else if(_2pScore < -998) {
//            winner = _1p + " 승리!(주사위 4)";
//        } else if (_1pScore > _2pScore) {
//            winner = _1p + " 승리!";
//        } else if (_1pScore < _2pScore) {
//            winner = _2p + " 승리!";
//        } else {
//            winner = "-무승부-";
//        }
//        return winner;
//    }
//}



public class homeworkDice3 {
    public static void main(String[] args) {
        Player player1 = new Player("김00");
        Player player2 = new Player("이00");

        gameSet.makePlayerList(player1, player2);


        gameSet.rollDice(player1);
        gameSet.rollDice(player2);


        Score.sumScore(player1);
        Score.sumScore(player2);

        Score.bonusScore(playersListSet);

        System.out.println(playersListSet[0]);
        System.out.println(playersListSet[1]);

        //플레이어
//        String _1p = "김땡땡";
//        String _2p = "이땡땡";
//
//        //총점
//        int[] score = gameSet.gamePlay(_1p,_2p);
//        int _1pScore = score[0];
//        int _2pScore = score[1];
//        System.out.println('\n' +_1p + " -> " + _1pScore + "점");
//        System.out.println(_2p + " -> " + _2pScore + "점");
//
//        //승자판단
//        System.out.print("결과는 ");
//        System.out.println(winnerCheck.winnerName(_1p, _2p, _1pScore, _2pScore));
    }
}