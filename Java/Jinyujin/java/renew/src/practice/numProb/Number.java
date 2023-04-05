package practice.numProb;

import utility.random.CustomRandom;

// 1. 1 ~ 100까지 숫자중 짝수만 출력해보자.
// 2. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!
// 3. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
public class Number {

    private int randomNumber;
    final private int MIN_NUM = 1;
    final private int MAX_NUM = 100;

    public Number() {
        // 먼저 커스텀랜덤을 이용하여 1 ~ 100까지 랜덤숫자 설정
        randomNumber = CustomRandom.generateNumber(MIN_NUM, MAX_NUM);
    }
    // 짝수만, 3의 배수만, 4의 배수만 출력하려면?
}
