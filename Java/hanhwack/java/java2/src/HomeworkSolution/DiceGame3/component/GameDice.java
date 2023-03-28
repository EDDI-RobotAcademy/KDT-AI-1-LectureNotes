package HomeworkSolution.DiceGame3.component;

import utility.random.CustomRandom;

//주사위 번호를 생성하고 이를 문자열로 표시
public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    //생성자 generateNumber을 통해 생성된 값을 diceNumber에 대입 초기화
    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    //getDiceNumber 사용시 생성자에서 나온 diceNumber반환
    public int getDiceNumber() {
        return diceNumber;
    }

    //toString 사용시 위에서 생성된 diceNumber와 특정구문을 String형태로 반환
    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}