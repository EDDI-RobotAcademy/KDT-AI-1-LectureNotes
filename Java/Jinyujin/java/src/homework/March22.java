package homework;

class Dice {
    private int diceFace;

    public Dice() {
        final int MIN = 1;
        final int MAX = 6;
        this.diceFace = (int) (Math.random() * MAX) + MIN;
    }
    public void setDiceFace(int diceFace) {
        this.diceFace = diceFace;
    }
    public int getDiceFace() {
        return diceFace;
    }

    private int dice1;
    private int dice2;
    private int dice3;
    private int dice4;
    private int totalScore;

    public void diceResuit(int dice1, int dice2, int dice3, int dice4) {
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.dice3 = dice3;
        this.dice4 = dice4;
    }
    public int totalScore(){
        return dice1 + dice2 + dice3 + dice4;
    }
    public void score() {
        this.totalScore = totalScore;
    }
    public void matchResult(final int totalScore) {
        final int WINNER_DECISION_NUMBER1 = 3;
        final int WINNER_DECISION_NUMBER2 = 4;

        if (totalScore % WINNER_DECISION_NUMBER1 == 0 || totalScore % WINNER_DECISION_NUMBER2 == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}

public class March22 {
    public static void main(String[] args) {
        final Dice dice1 = new Dice();
        final Dice dice2 = new Dice();
        final Dice dice3 = new Dice();
        final Dice dice4 = new Dice();
        System.out.println("첫 번째 주사위의 값은 = " + dice1.getDiceFace() + ", 두 번째 주사위의 값은 = " + dice2.getDiceFace() +
                ", 세 번째 주사위의 값은 = " + dice3.getDiceFace() + ", 네 번째 주사위의 값은 = " + dice4.getDiceFace());
    }
    final Dice Score = new Dice();

}
