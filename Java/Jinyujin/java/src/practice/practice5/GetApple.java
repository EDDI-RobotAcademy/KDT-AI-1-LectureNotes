package practice.practice5;

import utility.random.CustomRandom;

public class GetApple {

    private int getApple;

    public int getGetApple() {
        return getApple;
    }

    final private int MIN_APPLE = 3;
    final private int MAX_APPLE = 5;

    public GetApple() {
        // 수확할 때 얻는 사과는 3~5개
        getApple = CustomRandom.generateNumber(MIN_APPLE, MAX_APPLE);
    }

    @Override
    public String toString() {
        return "GetApple{" +
                "getApple=" + getApple +
                '}';
    }
}
