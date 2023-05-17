package practice.dice2.dice2BackLog.score;

public class Score {
    final private int score;

    public Score(int score) {
        this.score = score;
    }

    public void checkWin() {
        if (score % 3 == 0 || score % 4 == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }
}
