package practice.dice3;

import utility.random.CustomRandom;

public class Dice {
    // 3. 다이스에 필요한거 숫자
    final private int diceNumber;
    // 4. 그리고 다이스의 최고값 최고값
    final private int MAX_NUM = 6;
    final private int MIN_NUM = 1;
    // 5. 그리고 해야할 것
    // 6. 주사위 굴리기
    public Dice () {
        this.diceNumber = CustomRandom.generateNumber(MIN_NUM, MAX_NUM);
    }
    // 7. 그리고 스트링으로 diceNumber만 내보내기
    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
