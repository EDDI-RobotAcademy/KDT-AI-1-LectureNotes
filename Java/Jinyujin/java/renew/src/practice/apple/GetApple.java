package practice.apple;

import utility.random.CustomRandom;

// 수확을 할 때 얻는 사과는 3 ~ 5개
public class GetApple {
    final private int MIN_GET_APPLE = 3;
    final private int MAX_GET_APPLE = 5;
    private int getApple;

    public int getGetApple() {
        return getApple;
    }

    public GetApple() {
        getApple = CustomRandom.generateNumber(MIN_GET_APPLE, MAX_GET_APPLE);
    }

    @Override
    public String toString() {
        return "수확한 사과 개수 = " + getApple +
                '}';
    }
}
