import java.util.Arrays;

class Result_Condition {

    public boolean first_Condition() {
        Dice d = new Dice();
        System.out.println("asdflkjsadjfkldasfjlkfsdaklj");
        if(d.getDice()[1] % 2 == 0){
            return false;
        }

        return true;
    }

    public boolean third_Condition() {

        return false;
    }
}

class Dice {
    int START = 0;
    int dice_Number = 3;
    int dice_MIN = 1;
    int dice_MAX = 6;
    int[] dice = new int[dice_Number];
    boolean dice_Condition = true;


    @Override
    public String toString() {
        return "Dice{" +
                "dice=" + Arrays.toString(dice) +
                '}';
    }

    public void roll_dice() {

        Result_Condition rc = new Result_Condition();

        for (int i = START; i < dice_Number; i++) {
            dice[i] = (int) (Math.random() * (dice_MAX - dice_MIN + 1) + dice_MIN);
            if (i == 0) {
                rc.first_Condition();
            }
                setDice(dice);


        }
    }
    public void dice_While() {
        Result_Condition rc = new Result_Condition();

        while (true) {
            Dice dd = new Dice();
            dd.roll_dice();
            rc.first_Condition();
            System.out.println(dd);
        }
    }



    public Dice() {
        this.dice_Number = dice_Number;
        this.dice = dice;
    }

    public int getDice_Number() {
        return dice_Number;
    }

    public void setDice_Number(int dice_Number) {
        this.dice_Number = dice_Number;
    }

    public int[] getDice() {
        return dice;
    }

    public void setDice(int[] dice) {
        this.dice = dice;
    }
}
    public class Difficult_dice {
        public static void main(String[] args) {

            Dice d = new Dice();

            d.dice_While();

        }
    }



