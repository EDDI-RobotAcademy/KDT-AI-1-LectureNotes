package homework2;

public class Dice {
    int diceA = (int)(Math.random() * 6) + 1;
    int diceB = (int)(Math.random() * 6) + 1;
    int diceC = (int)(Math.random() * 6) + 1;
    int diceD = (int)(Math.random() * 6) + 1;

    int diceSum = diceA + diceB + diceC + diceD;;

    public Dice() {
        int diceSum = diceA + diceB + diceC + diceD;
    }

    public Boolean rule() {
        if(diceSum == 3 || diceSum % 4 == 0) {
            return true;
        }
        return false;
    }
}
class DiceInfo {
    public static void main(String[] args) {
        Dice diceInfo = new Dice();
        System.out.println("4개 주사위의 합 = " + diceInfo.diceSum);
        System.out.println(diceInfo.rule() ? "승리" : "패배");
    }
}
