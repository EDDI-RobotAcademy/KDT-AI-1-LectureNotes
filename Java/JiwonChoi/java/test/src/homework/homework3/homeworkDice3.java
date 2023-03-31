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
    public void setPlayerDices(int[] playerDices) {
        this.playerDices = playerDices;
    }

    @Override
    public String toString() {
        return "playerName = " + playerName + '\n' +
                "playerDices = " + Arrays.toString(playerDices) + '\n' +
                "DicesSum = " + beforeScore + '\n' +
                "+++++보너스 점수를 적용합니다.+++++"+ '\n' +
                "Score = " + finalScore + '\n' ;
    }
}


class gameSet { //게임 세팅
    static final int diceCount = 3; //다이스는 총 3개
    static Player[] playersListSet = new Player[2];

    public gameSet() {
    }

    static void makePlayerList(Player _1p, Player _2p) { //플레이어를 리스트에 넣기
        playersListSet[0] = _1p;
        playersListSet[1] = _2p;
    }

    public static void rollDice(Player player) { //주사위 굴리기
        int[] playerDices = new int[diceCount]; //다이스 수만큼 배열 생성 [  ][  ][  ]
        for (int i = 0; i < diceCount; i++) { //다이스 수만큼 반복
            playerDices[i] = (int) (Math.random() * 6) + 1; //다이스 배열에 랜덤숫자 저장
            player.setPlayerDices(playerDices); //위 다이스 배열을 플레이어 다이스배열 요소에 저장
        }

        if(playerDices[0] % 2 != 0){ //첫번째 주사위가 홀수면 [랜덤주사위1][0][0]으로 만듬
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

    static void bonusScore(Player[] playersListSet){ //3번째 다이스의 보너스점수 적용함수
        switch (playersListSet[0].playerDices[2]) { //플레이어1의 경우

            case 1 ://3번 다이스가 1인경우
                int player1_Dice1BonusScore = playersListSet[0].getBeforeScore() + 3;
                                            // = 플레이어1의      주사위합산점수에    보너스 3점-
                playersListSet[0].setBeforeScore(player1_Dice1BonusScore);
                                //-을 비포스코어에 저장
                int player2_Dice1BonusScore = playersListSet[1].getBeforeScore() - 3;
                                               // = 플레이어2의   주사위합산점수에    -3점
                playersListSet[1].setBeforeScore(player2_Dice1BonusScore);
                              //-을 비포스코어에 저장
                break;

            case 3 ://3번 다이스가 3인경우
                int player1_Dice3BonusScore = playersListSet[0].getBeforeScore() + 2;
                                            // = 플레이어1의      주사위합산점수에    보너스 2점-
                playersListSet[0].setBeforeScore(player1_Dice3BonusScore);
                                //-을 비포스코어에 저장
                break;

            case 4 ://3번 다이스가 4인경우 - 무조건 패
                int player1_Dice4BonusScore = 0;
                // = 플레이어1의    주사위합산점수를 0으로
                playersListSet[0].setBeforeScore(player1_Dice4BonusScore);
                                //비포스코어에 저장
                break;

            default ://이외 다이스들
                int player1_DiceDefaultBonusScore = playersListSet[0].getBeforeScore();
                                                    // = 플레이어1의    주사위합산점수를 그대로
                playersListSet[0].setBeforeScore( player1_DiceDefaultBonusScore);
                                //비포스코어에 저장
                break;

        }

        switch (playersListSet[1].playerDices[2]) { //플레이어2의 경우 (위와 동일)
            case 1 ://3번 다이스가 1인경우
                int player2_Dice1BonusScore = playersListSet[1].getBeforeScore() + 3;
                playersListSet[1].setBeforeScore(player2_Dice1BonusScore);

                int player1Dice1BonusScore = playersListSet[0].getBeforeScore() - 3;
                playersListSet[0].setBeforeScore(player1Dice1BonusScore);
                break;

            case 3 ://3번 다이스가 3인경우
                int player2Dice3BonusScore = playersListSet[1].getBeforeScore() + 2;
                playersListSet[1].setBeforeScore(player2Dice3BonusScore);
                break;

            case 4 ://3번 다이스가 4인경우 - 무조건 패
                int player2Dice4BonusScore = 0;
                playersListSet[1].setBeforeScore(player2Dice4BonusScore);
                break;

            default ://이외 다이스들
                int player2DiceDefaultBonusScore = playersListSet[1].getBeforeScore();
                playersListSet[1].setBeforeScore( player2DiceDefaultBonusScore);
                break;
        }

        //보너스스코어가 더해진 비포스코어를 각각의 파이널스코어에 넣어준다.
        playersListSet[0].setFinalScore(playersListSet[0].getBeforeScore());
        playersListSet[1].setFinalScore(playersListSet[1].getBeforeScore());

    }



}

class WinnerCheak { //0이 무조건패배


    public WinnerCheak(Player[] playersListSet) {
        // 둘다 세번째 다이스가 4면
        if (playersListSet[0].playerDices[2] == 4 && playersListSet[1].playerDices[2] == 4) {
            System.out.println("무승부 입니다.");
        } // 둘 중 한명의 세번째 다이스가 4면
        else if (playersListSet[0].playerDices[2] == 4 || playersListSet[1].playerDices[2] == 4) {
            if(playersListSet[0].playerDices[2] == 4){  //플레이어1의 세번째 다이스가 0이면
                System.out.println(playersListSet[0].getPlayerName() + "님 패배입니다."); // 플레이어1 패배
            } else {System.out.println(playersListSet[1].getPlayerName() + "님 패배입니다.");}// 그렇지 않으면 플레이어2 패배
        }// 둘 중 한명도 세번째 다이스가 4가 아니면
        else {
            if(playersListSet[0].getFinalScore() > playersListSet[1].getFinalScore()){  //플레이어1의 파이널스코어가 더 크면
                System.out.println(playersListSet[0].getPlayerName() + "님의 승리 입니다.");
            } else if (playersListSet[0].getFinalScore() < playersListSet[1].getFinalScore()) {//플레이어2의 파이널스코어가 더 크면
                System.out.println(playersListSet[1].getPlayerName() + "님의 승리 입니다.");
            } else if (playersListSet[0].getFinalScore() == playersListSet[1].getFinalScore()) {//플레이어1과 2의 파이널스코어가 같으면
                System.out.println("무승부 입니다.");
            }
        }
    }
}

//메인이 길어서 함수들 합쳐보려고 했는데 실패...
//class GamePlay{
//    public GamePlay(Player[] playersListSet) {
//
//        for(int i = 0; i < playersListSet.length; i++) {
//        gameSet.rollDice(playersListSet[i]);
//        Score.sumScore(playersListSet[i]);
//        Score.bonusScore(playersListSet);
//        new WinnerCheak(playersListSet);}
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

        new WinnerCheak(playersListSet);

    }
}