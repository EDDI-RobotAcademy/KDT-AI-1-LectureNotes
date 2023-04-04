package homework.homework6.diceGame5Ver2.game5;
import homework.homework6.diceGame5Ver2.utility.random.CustomRandom;

public class Dice {
    //다이스 설정
    final static int diceCount = 3; //다이스 총 개수
    String diceRound; //다이스이름 = 주사위1 주사위2 주사위3
    int diceNumber; //다이스 랜덤값 = 랜덤숫자
    public Dice(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public static Dice[] rollDice() { //주사위 굴리기 함수 ==> 다이스랜덤숫자 x 3 배열
        final int dice_Max = 6; //다이스 최대값
        final int dice_Min = 1; //다이스 최소값
        Dice[] dices = new Dice[diceCount];
        for (int i = 0; i < diceCount; i++) {
            int randomNumber = CustomRandom.generateNumber(dice_Min, dice_Max);
            dices[i] = new Dice(randomNumber);
        }

        return dices;
    }

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }
    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "'" + diceNumber + "'";
    }

}
