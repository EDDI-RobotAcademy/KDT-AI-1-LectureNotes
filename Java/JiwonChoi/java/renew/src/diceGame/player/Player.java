package diceGame.player;

import diceGame.game.Dice;
import diceGame.game.GameScore;

import java.util.ArrayList;
import java.util.List;

// Player(플레이어)에게 필요한게 뭐지 ?
public class Player {
    final private int MAX_DICE_NUM = 3; //주사위 최대개수
    final private String name;          //플레이어 이름
    final private List<Dice> gameDiceList = new ArrayList<>();
    //플레이어가 던진 주사위의 리스트==> [주사위1값, 주사위2값, 주사위3값]
    final private GameScore gameScore; //플레이어 총점수

    public Player(String name) {    //입력한 이름을 가진 플레이어 생성
        this.name = name;

        int diceNumberSum = rollDice(); //주사위 점수의 합?
        gameScore = new GameScore(diceNumberSum);// 가산한 값?
    }

    private int rollDice() {    //주사위 굴리기 함수
        final int FIRST_DICE_INFO = 0; //첫번째 주사위의 인덱스 위치를 나타냄
        final int DECISION_EVEN = 2;    //나눠서 짝수인지 확인할 숫자
        final int ODD = 1;              //나머지를 비교할 숫자

        int diceNumberSum = 0;  //시작 주사위합 = 0

        for (int i = 0; i < MAX_DICE_NUM; i++) {    //주사위 개수만큼 반복
            gameDiceList.add(new Dice());   //주사위 리스트에 던진 주사위를 추가
            diceNumberSum += gameDiceList.get(i).getDiceNumber();
            //주사위합에 계속 더함--> 주사위 리스트i번 요소인 다이스의 다이스넘버

            if (gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    //첫번째 주사위의 다이스넘버
                    DECISION_EVEN == ODD) {
                    //를 2로 나눈 값이 1이면 ==>홀수면
                break;
                //그냥 종료
            }
        }

        return diceNumberSum;
        //다이스 총합을 리턴
    }

    public Dice getSelectedGameDice(int index) {

        return gameDiceList.get(index);
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDiceList=" + gameDiceList +
                ", gameScore=" + gameScore +
                '}';
    }
}
