package homework2;

public class Dice {
    int diceA = (int)(Math.random() * 6) + 1;
    int diceB = (int)(Math.random() * 6) + 1;
    int diceC = (int)(Math.random() * 6) + 1;
    int diceD = (int)(Math.random() * 6) + 1;
    int diceSum = diceA + diceB + diceC + diceD;


    public Boolean rule() {
        if(diceSum % 3 ==0 || diceSum % 4 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceA=" + diceA +
                ", diceB=" + diceB +
                ", diceC=" + diceC +
                ", diceD=" + diceD +
                ", diceSum=" + diceSum +
                '}';
    }
}
class DiceInfo {
    public static void main(String[] args) {
        Dice diceInfo = new Dice();
        System.out.println(diceInfo);
        System.out.println(diceInfo.rule() ? "승리" : "패배");
    }
}
