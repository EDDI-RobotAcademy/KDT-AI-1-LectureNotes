package homework;

public class Dice {
    static int diceA;
    static int diceB;
    static int diceC;
    static int diceD;

    public void setDiceA(int diceA) {
        this.diceA = diceA;
    }

    public void setDiceB(int diceB) {
        this.diceB = diceB;
    }

    public void setDiceC(int diceC) {
        this.diceC = diceC;
    }

    public void setDiceD(int diceD) {
        this.diceD = diceD;
    }

    public static void main(String[] args) {
        final Dice dice1 = new Dice();
        dice1.diceA = (int)(Math.random() * 6) + 1;

        final Dice dice2 = new Dice();
        dice2.diceB = (int)(Math.random() * 6) + 1;

        final Dice dice3 = new Dice();
        dice3.diceC = (int)(Math.random() * 6) + 1;

        final Dice dice4 = new Dice();
        dice4.diceD = (int)(Math.random() * 6) + 1;

        System.out.println("A주사위 + B주사위 + C주사위 + D주사위 = " + (diceA + diceB + diceC + diceD));

        int diceSum = diceA + diceB + diceC + diceD;

        if (diceSum % 4 == 0 || diceSum % 3 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
