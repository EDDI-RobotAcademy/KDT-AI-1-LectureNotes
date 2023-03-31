package dice3;

import java.util.List;

public class Score {

    int Score = 0;

    public Score(int score) {
        Score = score;
    }

    public Score(List<Integer> doDice1) {
        for (int oneDice : doDice1) {
            Score += oneDice;
        }
    }


}
