package practice.dice3;
import java.util.ArrayList;
import java.util.List;
public class Dice {
    final private int MAX_DICE_NUM = 6;
    final private int MIN_DICE_NUM = 1;
    final private int diceNumber; // 주사위 숫자
    public Dice () {
        this.diceNumber =
                (int)(Math.random()*(MAX_DICE_NUM - MIN_DICE_NUM + 1)) + MIN_DICE_NUM;
    }
    public int getDiceNumber() {
        return diceNumber;
    }
    // Dice 굴리기
}