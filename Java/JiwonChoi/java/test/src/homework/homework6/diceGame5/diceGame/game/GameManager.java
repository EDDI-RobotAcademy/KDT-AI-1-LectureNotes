package homework.homework6.diceGame5.diceGame.game;

import diceGame.game.Dice;
import diceGame.game.GameScore;
import diceGame.player.Player;
import homework.homework6.diceGame5.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 2;
    public List<Player> playerList = new ArrayList<>(); //플레이어 정보를 담은 플레이어리스트

    public GameManager() {
        for (int i = 0; i < playerList.size(); i++) { //플레이어 숫자만큼 반복<======여러명이 하도록 수정할 것임
            playerList.add(new Player("플레이어" + (i + 1)));//플레이 리스트에 새플레이어정보 추가
            System.out.println(playerList.get(i));//플레이어1정보 전부 출력
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        //현재 플레이어 인덱스를 입력하면 타겟 플레이어 인덱스 출력하는 함수
        // 상대편 찾기 (1:1 상황)
        List<Integer> indexNumList = new ArrayList<>();
        for(int i =0; i  <playerList.size(); i++){
            indexNumList.add(i);
        }
        indexNumList.remove(currentPlayerIndex);
        int targetPlayerIndex = indexNumList.get(CustomRandom.generateNumber(playerList.size()));

//        if (currentPlayerIndex == 0) {  //하지만 내가 0이면 1출력
//            targetPlayerIndex = 1;
//        }
        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber (int playerIndex) { // 입력 플레이어의 스페셜 다이스=세번째 다이스
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS; //0123 이니까 인덱스2 다이스
        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);
        // =플레이어리스트중_ 입력인덱스플레이어의_ 세번째다이스넘버
        if (currentPlayerSpecialDice == null) { return 0; }
        //만약 세번째 다이스가 없으면 그냥 종료

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();
        //다이스클래스인 세번째주사위의 정수타입 넘버값을 출력
        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {        //게임실행
        final int STEAL = 1;    //3번째에서 가산해야할 주사위번호
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;      //가산값
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < playerList.size(); i++) {  //플레이어 인원만큼 반복
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i); //i번째 플레이어의 3번째 스페셜다이스 값
            if (currentPlayerSpecialDiceNumber == 0) { continue; }  //만약 0이면 처음으로다시?

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            diceGame.game.GameScore targetPlayerScore =
                    playerList.get(targetPlayerIndex).getGameScore();

            diceGame.game.GameScore currentPlayerScore=
                    playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
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
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        diceGame.game.GameScore firstPlayerScore = playerList.get(0).getGameScore();
        GameScore secondPlayerScore = playerList.get(1).getGameScore();

        final int firstPlayerScoreTotalScore = firstPlayerScore.getTotalScore();
        final int secondPlayerScoreTotalScore = secondPlayerScore.getTotalScore();

        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerList.get(0).getName());
            return;
        }
        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerList.get(1).getName());
            return;
        }

        System.out.println("무승부");
    }
}