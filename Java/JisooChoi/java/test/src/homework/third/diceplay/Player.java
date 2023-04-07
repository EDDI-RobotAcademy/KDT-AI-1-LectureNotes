package homework.third.diceplay;

public class Player {
    int score = 0;

    public Player() {
    }

    public int case1TakeScoreMe() {
        return score += 3;
    }

    public int case1TakeScoreYou() {
        return score -= 3;
    }

    public int case2AddScoreMe() {
        return score += 2;
    }

    public int case2AddScoreYou() {
        return score -= 2;
    }
}
