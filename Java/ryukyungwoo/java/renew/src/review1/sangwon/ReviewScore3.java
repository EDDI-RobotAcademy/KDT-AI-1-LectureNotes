package review1.sangwon;

import java.util.List;

public class ReviewScore3 {
    // 소문자 표현이 더 좋았을 것 같습니다.
    int Score = 0;

    public ReviewScore3(int score) {
        Score = score;
    }

    public ReviewScore3(List<Integer> doDice1) {
        for (int oneDice : doDice1) {
            Score += oneDice;
        }
    }
}
