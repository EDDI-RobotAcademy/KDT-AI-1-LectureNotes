package homework;

class Dice {
    private static int diceA;
    private static int diceB;
    private static int diceC;
    private static int diceD;
    int score;

    public void setDiceA() {
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

    public void Dice2 () {

        final Dice dice1 = new Dice();
        dice1.diceA = (int)(Math.random() * 6) + 1;

        final Dice dice2 = new Dice();
        dice2.diceB = (int)(Math.random() * 6) + 1;

        final Dice dice3 = new Dice();
        dice3.diceC = (int)(Math.random() * 6) + 1;

        final Dice dice4 = new Dice();
        dice4.diceD = (int)(Math.random() * 6) + 1;



    }

    @Override
    public String toString() {
        return "Dice{" +
                "score=" + score +
                '}';
    }

    public boolean Game() {
        int diceSum = diceA + diceB + diceC + diceD;

        if (diceSum % 4 == 0 || diceSum % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
public class Correct {
    public static void main(String[] args) {
        Dice game1 = new Dice();
        System.out.println(game1.Game()? "승리!" : "패배!");
    }
}

