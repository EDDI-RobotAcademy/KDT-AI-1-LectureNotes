package homework;

class Dice2 {

    final int MAX_DICE = 4;

    final int[] diceNumberArr = new int[MAX_DICE];
    int totalScore;

    public Dice2() {
        for (int i = 0; i < 4; i++) {
            diceNumberArr[i] = (int)(Math.random()*6)+1;
            totalScore += diceNumberArr[i];
        }
    }


    public Integer getMaxDice() {

        return MAX_DICE;
    }

    public Integer getTotalScore() {

        return totalScore;
    }



}

public class ranDice2 {
    public static void main(String[] args) {

        final Dice2 dice = new Dice2();

        System.out.println("주사위 " + dice.getMaxDice() +"개의 합은" + dice.getTotalScore());


        if (dice.getTotalScore() % 3 == 0 || dice.getTotalScore() % 4 == 0) {
            System.out.println("승리입니다");
        } else {
            System.out.println("패배하였습니다");
        }


    }
}
