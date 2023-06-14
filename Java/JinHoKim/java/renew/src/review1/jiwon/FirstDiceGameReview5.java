package review1.jiwon;

import java.util.Arrays;

// 아래처럼 static이 붙는 구조는 설계 관점에서 의존성을 만들어냅니다.
// 모든 코드가 static 의존성을 가지게 되는 경우
// 새로운 변경사항을 적용하는 것의 난이도가 기하급수적으로 올라가게 됩니다.
// 이 의존성이라는 것은 많이 엮이면 엮일수록
// 사람 관계처럼 쉽게 빠져나가지 못하게 됩니다.
import static review1.jiwon.ReviewGameSet.diceCount;
import static review1.jiwon.ReviewGameSet.playersListSet;

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

// 코드 작성시 gameSet이라고 만들었는데
// 클래스 이름은 반드시 앞에 시작을 대문자로 만들어야 합니다.
// 그러므로 GameSet으로 만드는 것이 더 좋았을 것 같습니다.
class ReviewGameSet { //게임 세팅
    static final int diceCount = 3; //다이스는 총 3개
    static Player[] playersListSet = new Player[2];

    public ReviewGameSet() {
    }

    static void makePlayerList(Player _1p, Player _2p) { //플레이어를 리스트에 넣기
        playersListSet[0] = _1p;
        playersListSet[1] = _2p;
    }

    // rollDice의 경우엔 Utility(유틸리티) 함수가 되는 것이 별로 좋지 않습니다.
    // 아마 여기서 static을 사용했기 때문에
    // new를 사용하지 않는 방식의 코드 패턴이 만들어졌을 가능성이 보입니다.
    // 또한 리뷰에서는 주석을 달고 있지만
    // 실전 코드라면 주석 없이 읽기 편한 코드로 구성되어 있는 것이 더 좋긴합니다.
    public static void rollDice(Player player) { //주사위 굴리기
        int[] playerDices = new int[diceCount]; //다이스 수만큼 배열 생성 [  ][  ][  ]
        for (int i = 0; i < diceCount; i++) { //다이스 수만큼 반복
            playerDices[i] = (int) (Math.random() * 6) + 1; //다이스 배열에 랜덤숫자 저장
            player.setPlayerDices(playerDices); //위 다이스 배열을 플레이어 다이스배열 요소에 저장
        }

        // 상수값이 생으로 너무 많습니다.
        // 그래서 아래 주석도 추가되었다 볼 수 있습니다.
        // 그리고 주사위 개수 증가에 대한 대응이 불가합니다.
        if(playerDices[0] % 2 != 0){ //첫번째 주사위가 홀수면 [랜덤주사위1][0][0]으로 만듬
            playerDices[1] = 0;
            playerDices[2] = 0;
        }
    }
    // 이 부분은 루프를 돌면서 홀수가 나왔다면
    // 즉시 루프를 break 하는 형태로 구현했으면 더 좋았을 것 같습니다.
    // 혹은 루프 내에 if 문을 배치하여 해결 할 수도 있습니다.

    /*
    대략 아래와 같은 흐름이였다면 홀수가 나오자마자 끝냈을 것입니다.
    물론 아래에서도 패턴을 읽어야 해서 불편함이 있고
    이를 개선하기 위해서라면 0을 EVEN이라 하면 더 좋습니다.
    또한 playerDices[0]도 어느정도는 불편해서
    시작값임을 알려주는게 더 좋고요.

    되도록 주석을 달지 않고도 쉽게 읽히는 구성을 만들어주는 것이 Best 입니다.
    최고의 문서는 코드다라는 말이 있을 정도이기 때문입니다.

    for (int i = 0; i < diceCount; i++) {
        playerDices[i] = (int) (Math.random() * 6) + 1;
        if (playerDices[FIRST_DICE] % 2 != EVEN) {
            return;
        } else {
            player.setPlayerDices(playerDices);
        }
    }
     */
}

class Score{

    static void sumScore(Player player){
        int startScore = 0;
        for (int i =0; i < diceCount; i++) {
            startScore += player.playerDices[i];
        }
        // 우선 beforeScore는 특수 주사위 이전의 값을 판정하려고 배치한 것 같은 느낌이네요.
        // 디버깅 목적이었다면 System.out.println()으로 출력 하는 것이 더 좋았을 것 같습니다.
        player.setBeforeScore(startScore);
    }

    // ReviewGameSet에 멤버 변수로 있는 playersListSet이 인자로 입력됩니다.
    // 또한 이 정보는 static으로 넘어왔기 때문에
    // 정보의 추적성 차원에서 문제가 있었습니다.
    static void bonusScore(Player[] playersListSet){ //3번째 다이스의 보너스점수 적용함수
        // 결론적으로 플레이어 1의 특수 주사위 값을 보려고 했습니다.
        // 그러나 현재 흐름에선 playersListSet이 뭐지 ? 를 한 번 살펴보고
        // playerDices[2]은 특수 주사위지 ? 라는 상당히 뎁스가 깊은 생각을 요구하고 있습니다.
        switch (playersListSet[0].playerDices[2]) { //플레이어1의 경우

            // 아래 파트는 계산을 하게 되는 부분인데
            // 이전 점수와 보너스 점수와 여러가지 점수들이 혼재되어 있습니다.
            // 불필요한 중복이 발생하고 있는 상태라서 개선이 필요합니다!
            // 우선 이 부분은 생각하지 말고 나머지 파트를 개선하면 좋을 것 같습니다.
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

        // 또 다른 사용자 2번에 대해서 반복 코드를 작성했습니다.

        /*
        아래 정도만 되었어도 조금 더 코드가 간결하고 명시적이었을 것입니다.

        for (int playerIndex = 0; playerIndex < PLAYER_NUM; playerIndex++) {
            switch(playersListSet[playerIndex].playerDices[SPECIAL_DICE]) {
            }
        }
         */
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
//        ReviewGameSet.rollDice(playersListSet[i]);
//        Score.sumScore(playersListSet[i]);
//        Score.bonusScore(playersListSet);
//        new WinnerCheak(playersListSet);}
//    }
//}

public class FirstDiceGameReview5 {
    public static void main(String[] args) {
        Player player1 = new Player("김00");
        Player player2 = new Player("이00");

        ReviewGameSet.makePlayerList(player1, player2);

        ReviewGameSet.rollDice(player1);
        ReviewGameSet.rollDice(player2);

        Score.sumScore(player1);
        Score.sumScore(player2);

        // 디버깅 목적
        System.out.println(playersListSet[0]);
        System.out.println(playersListSet[1]);

        // playersListSet이 어디 있는지 알 수가 없습니다.
        // 현재 여기서 자동 완성으로 static을 붙여줘서 해결해주고 있으나
        // playersListSet을 생성하는 조건이나 새로운 규약이 생길때 대응이 매우 어려워집니다.
        // 일단 이 정보가 어디 있는지도 알 수 없기 때문입니다.
        Score.bonusScore(playersListSet);

        System.out.println(playersListSet[0]);
        System.out.println(playersListSet[1]);

        // WinnerCheck에는 오타가 있는 것 같습니다.
        new WinnerCheak(playersListSet);

        // 일단 완성 했다는 것 자체는 아주 훌륭합니다!
        // 리뷰를 바탕으로 개선을 시도해보면
        // 더 좋은 결과를 얻을 수 있을 것 같습니다!
    }
}
