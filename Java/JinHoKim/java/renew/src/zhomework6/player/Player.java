package zhomework6.player;

import zhomework6.game.Dice;
import zhomework6.game.GameScore;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private int MAX_DICE_NUM = 3; //던지는 주사위 갯수
    final private String name; // 플레이어 이름
    final private List<Dice> gameDiceList = new ArrayList<>(); // 던지는 주사위 3개 리스트로 넣기 => 참초변수 gameDiceList 를 자료형 Dice 로 리스트 넣기
                                                                //나중에 주사위 값 가져올 때는 .getDiceNumber();로 int 형으로 값을 가져온다
    final private GameScore gameScore;

    public Player(String name) { // 플레이어 이름 매개변수로 받기
        this.name = name;
        int diceNumberSum = rollDice();
        this.gameScore = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;
        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) { // 주사위 3개 던지는거
            gameDiceList.add(new Dice()); // 1 ~ 6까지의 랜덤 주사위 3개를 gameDiceList 에 더함
            diceNumberSum += gameDiceList.get(i).getDiceNumber();
            //gameDiceList.get(i) => 다이스 객체의 리스트값 + .getDiceNumber() => 진짜 주사위의 값 // gameDiceList.get(i)의 자료형은 Dice 이다
            //gameDiceList.get(i) 는
            //.getDiceNumber() => int 형의 주사위 값을 가져오는것이다

            if (gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() % DECISION_EVEN == ODD) {
                break;
                // 1. 첫번째 주사위의 인덱스 주사위 값이 홀수인경우 지나가라
                //2.  첫 번째 인덱스 위치에있는 주사위의 값이 1이면 홀 수기 때문에 게임 종료 break;하고 빠져나오기
            }
        }
        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        if (gameDiceList.size() > index) { //리스트안에있는 주사위 갯수가 인덱스 보다 크다??
            return gameDiceList.get(index);// 들어온 인덱스 위치의 주사위 값 가져오기
        }

        return null;
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
