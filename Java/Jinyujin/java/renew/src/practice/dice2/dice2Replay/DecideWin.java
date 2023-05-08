package practice.dice2.dice2Replay;

public class DecideWin {
    // 주사위 총합 변수인데 diceSum이랑 이름 같게 하면 헷갈리니까
    // score 라는 이름을 활용해보자
    final private int score;
    final private int WIN_DECISION_NUMBER1 = 3;
    final private int WIN_DECISION_NUMBER2 = 4;

    public DecideWin(int score) {
        this.score = score;
    }

    public void decideWinner() {
        if (score % WIN_DECISION_NUMBER1 == 0 ||
                score % WIN_DECISION_NUMBER2 == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}
