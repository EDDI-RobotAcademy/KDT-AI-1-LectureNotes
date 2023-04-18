package problems.prob12;

import customLibrary.CustomRandom;

public class Student {
    int score;

    int minScore = 0;
    int maxScore = 100;

    public Student() {
        this.score = CustomRandom.generateNumber(maxScore);
    }

    public int getScore() {
        return score;
    }

}


