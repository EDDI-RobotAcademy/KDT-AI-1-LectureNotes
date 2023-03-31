package homework.homework3;
import java.util.Arrays;
import utility.random.CustomRandom;

import static homework.homework3.Dice.DICE_MAX;
import static homework.homework3.Dice.DICE_MIN;
import static homework.homework3.Dice.diceCount;

class Player { //플레이어정보
    String playerName;
    Dice[] playerDices;
    Score playerScore;

    public Player(String playerName) { //플레이어 생성
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerDices(Dice[] playerDices) {
        this.playerDices = playerDices;
    }

    public Dice[] getPlayerDices() {
        return playerDices;
    }

    public Score getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Score playerScore) {
        this.playerScore = playerScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerDices=" + Arrays.toString(playerDices) +
                ", playerScore=" + playerScore +
                '}';
    }
}


class Dice {
    static final int diceCount = 3; //다이스는 총 3개
    static final int DICE_MAX = 6;
    static final int DICE_MIN = 1;
    int diceNumber;

    public Dice(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}


class Score {
    int sumAllDices;
    int finalScore;

    public Score() {
    }

    public int getSumAllDices() {
        return sumAllDices;
    }

    public void setSumAllDices(int sumAllDices) {
        this.sumAllDices = sumAllDices;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sumAllDices=" + sumAllDices +
                ", finalScore=" + finalScore +
                '}';
    }
}

//    static void bonusScore(Player[] playersListSet){ //3번째 다이스의 보너스점수 적용함수
//        switch (playersListSet[0].playerDices[2]) { //플레이어1의 경우
//
//            case 1 ://3번 다이스가 1인경우
//                int player1_Dice1BonusScore = playersListSet[0].getBeforeScore() + 3;
//                                            // = 플레이어1의      주사위합산점수에    보너스 3점-
//                playersListSet[0].setBeforeScore(player1_Dice1BonusScore);
//                                //-을 비포스코어에 저장
//                int player2_Dice1BonusScore = playersListSet[1].getBeforeScore() - 3;
//                                               // = 플레이어2의   주사위합산점수에    -3점
//                playersListSet[1].setBeforeScore(player2_Dice1BonusScore);
//                              //-을 비포스코어에 저장
//                break;
//
//            case 3 ://3번 다이스가 3인경우
//                int player1_Dice3BonusScore = playersListSet[0].getBeforeScore() + 2;
//                                            // = 플레이어1의      주사위합산점수에    보너스 2점-
//                playersListSet[0].setBeforeScore(player1_Dice3BonusScore);
//                                //-을 비포스코어에 저장
//                break;
//
//            case 4 ://3번 다이스가 4인경우 - 무조건 패
//                int player1_Dice4BonusScore = 0;
//                // = 플레이어1의    주사위합산점수를 0으로
//                playersListSet[0].setBeforeScore(player1_Dice4BonusScore);
//                                //비포스코어에 저장
//                break;
//
//            default ://이외 다이스들
//                int player1_DiceDefaultBonusScore = playersListSet[0].getBeforeScore();
//                                                    // = 플레이어1의    주사위합산점수를 그대로
//                playersListSet[0].setBeforeScore( player1_DiceDefaultBonusScore);
//                                //비포스코어에 저장
//                break;
//
//        }
//
//        switch (playersListSet[1].playerDices[2]) { //플레이어2의 경우 (위와 동일)
//            case 1 ://3번 다이스가 1인경우
//                int player2_Dice1BonusScore = playersListSet[1].getBeforeScore() + 3;
//                playersListSet[1].setBeforeScore(player2_Dice1BonusScore);
//
//                int player1Dice1BonusScore = playersListSet[0].getBeforeScore() - 3;
//                playersListSet[0].setBeforeScore(player1Dice1BonusScore);
//                break;
//
//            case 3 ://3번 다이스가 3인경우
//                int player2Dice3BonusScore = playersListSet[1].getBeforeScore() + 2;
//                playersListSet[1].setBeforeScore(player2Dice3BonusScore);
//                break;
//
//            case 4 ://3번 다이스가 4인경우 - 무조건 패
//                int player2Dice4BonusScore = 0;
//                playersListSet[1].setBeforeScore(player2Dice4BonusScore);
//                break;
//
//            default ://이외 다이스들
//                int player2DiceDefaultBonusScore = playersListSet[1].getBeforeScore();
//                playersListSet[1].setBeforeScore( player2DiceDefaultBonusScore);
//                break;
//        }
//
//        //보너스스코어가 더해진 비포스코어를 각각의 파이널스코어에 넣어준다.
//        playersListSet[0].setFinalScore(playersListSet[0].getBeforeScore());
//        playersListSet[1].setFinalScore(playersListSet[1].getBeforeScore());
//
//    }
//}


class Game {
    static final int PLAYER_COUNT = 2;
    static Player[] playersList = new Player[PLAYER_COUNT];

    public static Player[] getPlayersList() {
        return playersList;
    }

    public static void setPlayersList(Player[] playersList) {
        Game.playersList = playersList;
    }

    static public Player[] addPlayers(String player1, String player2) {
        Player[] playersList= {new Player(player1), new Player(player2)};

        return playersList;
    }

    static Dice rollDices() {
        int randomNumber = CustomRandom.generateNumber(DICE_MAX, DICE_MIN);
        return new Dice(randomNumber);
    }

    static void rollAllDice(Player[] playersList) {
        //플레이어한테 다이스 개수만큼 배열 만들어서 랜덤 숫자 넣음 ==>  [랜덤] [랜덤] [랜덤]
        for (int i = 0; i < playersList.length; i++) {  //다이스 개수만큼 배열 만들어서
            Dice[] dices = new Dice[diceCount];
            for (int j = 0; j < diceCount; j++) {     //랜덤 숫자 넣음
                dices[j] = rollDices();
            }
            playersList[i].setPlayerDices(dices);   //플레이어한테
            if(playersList[i].getPlayerDices()[0].diceNumber % 2 != 0){
                playersList[i].getPlayerDices()[1].setDiceNumber(0);
                playersList[i].getPlayerDices()[2].setDiceNumber(0);
            }

        }
    }

    static void sumAllDices(Player[] playersList) { //플레이어 리스트 플레이어 각각 다이스 합하기
        int sumScore = 0;

        for (int i = 0; i < playersList.length; i++) {    //플레이어 수만큼 반복
            int startScore = 0;
            playersList[i].setPlayerScore(new Score());

            for (int j = 0; j < diceCount; j++) {       //다이스 수만큼 반복
                startScore += playersList[i].getPlayerDices()[j].getDiceNumber();//다이스 넘버 더해줌
                sumScore = startScore;
            }
            playersList[i].getPlayerScore().setSumAllDices(sumScore);
               //그 값을 플레이어 스코어에 저장
        }
    }

    void SpecialDice3 () {
       int SpecialDice3Number = playersList[0].getPlayerDices()[diceCount-1].getDiceNumber();
       //3번째 다이스

       switch (SpecialDice3Number) {
           case 1:
               int finalScore = playersList[0].getPlayerScore().getSumAllDices() + 3;

               break;
           case 3:
//               int finalScore = playersList[0].getPlayerScore().getSumAllDices() + 2;
               break;

           case 4:
               break;

           default:
               break;
       }
    }


    @Override
    public String toString() {
        return "Game{" +
                "playersList=" + Arrays.toString(playersList) +
                '}';
    }
}

//class WinnerCheak { //0이 무조건패배
//
//
//    public WinnerCheak(Player[] playersListSet) {
//        // 둘다 세번째 다이스가 4면
//        if (playersListSet[0].playerDices[2] == 4 && playersListSet[1].playerDices[2] == 4) {
//            System.out.println("무승부 입니다.");
//        } // 둘 중 한명의 세번째 다이스가 4면
//        else if (playersListSet[0].playerDices[2] == 4 || playersListSet[1].playerDices[2] == 4) {
//            if(playersListSet[0].playerDices[2] == 4){  //플레이어1의 세번째 다이스가 0이면
//                System.out.println(playersListSet[0].getPlayerName() + "님 패배입니다."); // 플레이어1 패배
//            } else {System.out.println(playersListSet[1].getPlayerName() + "님 패배입니다.");}// 그렇지 않으면 플레이어2 패배
//        }// 둘 중 한명도 세번째 다이스가 4가 아니면
//        else {
//            if(playersListSet[0].getFinalScore() > playersListSet[1].getFinalScore()){  //플레이어1의 파이널스코어가 더 크면
//                System.out.println(playersListSet[0].getPlayerName() + "님의 승리 입니다.");
//            } else if (playersListSet[0].getFinalScore() < playersListSet[1].getFinalScore()) {//플레이어2의 파이널스코어가 더 크면
//                System.out.println(playersListSet[1].getPlayerName() + "님의 승리 입니다.");
//            } else if (playersListSet[0].getFinalScore() == playersListSet[1].getFinalScore()) {//플레이어1과 2의 파이널스코어가 같으면
//                System.out.println("무승부 입니다.");
//            }
//        }
//    }
//}

    public class homeworkDice3 {
        public static void main(String[] args) {

            new Game();
            Player player1 = new Player("김일번");
            Player player2 = new Player("김이번");
            Player[] playersList = {player1, player2};

            Game.setPlayersList(playersList);
            Game.rollAllDice(playersList);


            Game.sumAllDices(playersList);
            System.out.println(Game.getPlayersList()[0]);
            System.out.println(Game.getPlayersList()[1]);






        }
    }
