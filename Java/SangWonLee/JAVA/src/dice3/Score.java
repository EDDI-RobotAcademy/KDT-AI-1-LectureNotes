package dice3;

import java.util.List;

public class Score {

    int Score = 0;

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public Score(List<Integer> doDice1) {
        for (int oneDice : doDice1) {
            Score += oneDice;
        }
        System.out.println(Score);
        setScore(Score);
    }


}
