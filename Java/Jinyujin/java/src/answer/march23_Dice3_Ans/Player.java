package answer.march23_Dice3_Ans;

import java.util.Arrays;

public class Player {
    // player를 만들었으면 얘한테만 일단 집중 - 보기에도 사후 관리하기에도 편하게 하기 위함
    // player에게 필요한게 뭐지?

    final private String name; // 당연히 이름 있을 것
    final int MAX_DICE_NUMBER = 3;
    final private GameDice[] gameDices = new GameDice[MAX_DICE_NUMBER];// -> gamedice 클래스 생성
    final private GameScore gameScore;
    // 주사위 같은건 별도로 이름 부여 받을 필요 없으니 그냥 루프 돌리면 됨
    // 프로그램 전체를 돌리는데는 얘네가 필요하구나 -> 얘네한테만 집중이 가능해짐

    // 또 만들꺼 뭐있지 하지말고 일단 만들어진걸로 킵고잉 하다보면 생각난다
    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        final int DECISION_EVEN = 2;
        final int ODD = 1;
        final int FIRST_DICE_INFO = 0;
        // 생성자를 구성하는 애들 따로 빼줌

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            gameDices[i] = new GameDice();

            diceNumberSum += gameDices[i].getDiceNumber();

            // for문 0과 같다고 생각할 수 있기에 첫번째 주사위라는 것 명시해주자 위로
            if (gameDices[FIRST_DICE_INFO].getDiceNumber() % DECISION_EVEN == ODD) {
                break; // 그리고 점수 인덱스는 플레이어를 따라 움직여야 -> gamescore 클래스로
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
        return "Player{" +
                "name='" + name + '\'' +
                ", MAX_DICE_NUMBER=" + MAX_DICE_NUMBER +
                ", gameDices=" + Arrays.toString(gameDices) +
                ", gameScore=" + gameScore +
                '}';
        // toString 생성하고 수정 -> 그냥 재생성하면 됨 alt+insert에 있음
    }
}
