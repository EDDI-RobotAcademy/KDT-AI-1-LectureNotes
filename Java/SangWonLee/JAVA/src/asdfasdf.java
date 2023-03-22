class Game {

}
class Dice{
    int diceNumber;
}
class Score {
    int totalScore;
}


public class asdfasdf {



    public static void main(String[] args) {

        int START = 0;
        int MAX_DICE = 4;
        int[] diceNumberArr = new int[MAX_DICE];
        int totalScore;
        for(int i = START; i < MAX_DICE; i++) {
            int d_Number = (int) ((Math.random() * 6) + 1);
            diceNumberArr[i] = d_Number;
            System.out.println(diceNumberArr[i]);

        }
        System.out.println(diceNumberArr);
    }

}
