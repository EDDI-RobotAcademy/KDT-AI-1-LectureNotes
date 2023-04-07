package _homework_03_01_review.component;

import java.util.Arrays;
//Player에게 필요한게 뭐지 ?
public class Player  {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    final private GameScore gameScore;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }

    //주사위 굴리기
    private int rollDice() {
        //첫번째 주사위 인덱스
        final int FIRST_DICE_INFO = 0;
        //어떤 숫자를 2로나눈 나머지가 1이면 반드시 홀수임
        //나누기 2를 해서 짝수 판정을 할 것임
        final int DECISION_EVEN = 2;
        //근데 홀수가 나오면
        final int ODD = 1;

        //주사위 값 합치기
        int diceNumberSum = 0;

        //주사위 개수만큼 반복
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            //주사위 1개씩 루프 돌면서 굴림
            gameDices[i] = new GameDice();

            //주사위 굴려서 나온 숫자값 누산
            diceNumberSum += gameDices[i].getDiceNumber();

            //첫번째 주사위가 짝수일때만
            //두번째, 세번째를 굴릴수 있으므로 홀수 판정
            if (gameDices[FIRST_DICE_INFO].getDiceNumber() %
                    DECISION_EVEN == ODD) {
                //홀수 판정되면 반복 중지
                break;
            }
        }

        //주사위 합산 값 반환
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
                ", gameDices=" + Arrays.toString(gameDices) +
                ", gameScore=" + gameScore +
                '}';
    }
}
