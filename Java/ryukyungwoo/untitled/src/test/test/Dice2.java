package test.test;

public class Dice2 {
    public static void main(String[] args) {

        int diceSum = 0;
        final int DICE_NUMBER = 4;

        final int MAX = 6;
        final int MIN = 1;


        for (int i = 0; i < DICE_NUMBER; i++) {
            diceSum += (int) (Math.random() * (MAX - MIN + 1) + MIN);
        }
        System.out.println("내 주사위의 합: " + diceSum);

        final int WINNER_DECISION = 4;

        if (diceSum % WINNER_DECISION == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }}