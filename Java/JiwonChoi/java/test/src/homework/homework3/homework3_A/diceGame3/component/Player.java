package homework.homework3.homework3_A.diceGame3.component;

import java.util.Arrays;

//player에게 필요한 것은 무엇일까?
public class Player {
    final private int MAX_DICE_NUM = 3; //주사위 개수
    final  private  String name;    //player 이름
    final  private  GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    //배열 gameDices은 주사위 수만큼 = 배열 gameDices은 주사위를 던지는 수 만큼 공간이 있음
    final private GameScore gameScore;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        //게임 설정
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;
        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDices[i] = new GameDice();

            diceNumberSum += gameDices[i].getDiceNumber();

            if (gameDices[FIRST_DICE_INFO].getDiceNumber()%
                    DECISION_EVEN == ODD) {
                break;
            }
        }
        return diceNumberSum;
    }

    public GameDice getSelectedGameDice(int index) {
        return gameDices[index];
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  "주사위 개수 =" + MAX_DICE_NUM +
                ", 이름 ='" + name + '\'' +
                '\n' + "주사위를 던집니다. ----> " + Arrays.toString(gameDices) +
                '\n' +"gameScore=" + gameScore+ '\n';
    }
}
