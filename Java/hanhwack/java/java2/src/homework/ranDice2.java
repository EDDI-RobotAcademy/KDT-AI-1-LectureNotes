package homework;

class Dice2 {
<<<<<<< HEAD
    int MAX_DICE = 4;
=======
    final int MAX_DICE = 4;
>>>>>>> c2a4b144103f6f0c33423335d4173342db959086
    final int[] diceNumberArr = new int[MAX_DICE];
    int totalScore;

    public Dice2() {
        for (int i = 0; i < 4; i++) {
            diceNumberArr[i] = (int)(Math.random()*6)+1;
            totalScore += diceNumberArr[i];
        }
    }
<<<<<<< HEAD

    public Integer getMaxDice() {

        return MAX_DICE;
    }

    public void getMaxDice(Integer MAX_DICE) {
        this.MAX_DICE = MAX_DICE;
    }
=======
>>>>>>> c2a4b144103f6f0c33423335d4173342db959086
    public Integer getTotalScore() {

        return totalScore;
    }

    public void getTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }


}

public class ranDice2 {
    public static void main(String[] args) {

        final Dice2 dice = new Dice2();

<<<<<<< HEAD
        System.out.println("주사위 " + dice.getMaxDice() +"개의 합은" + dice.getTotalScore());

=======
>>>>>>> c2a4b144103f6f0c33423335d4173342db959086
        if (dice.getTotalScore() % 3 == 0 || dice.getTotalScore() % 4 == 0) {
            System.out.println("승리입니다");
        } else {
            System.out.println("패배하였습니다");
        }


    }
}
