package newdice;

import random.CustomRandom;

public class Die {
    Player1 player1 = new Player1("민");
    //Player2 player2 = new Player2("훈");
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public Die() {
        diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }
    @Override
    public String toString() {
        return "주사위 값: " + diceNumber;
    }



    public void specialDice(){
        final int Steal = 1;
        final int Buff = 3;
        final int Death = 4;

        final int Steal_Score = 3;
        final int Buff_Score = 2;
        final int Death_Score = -777;

        switch (diceNumber) {
//            case Steal:
//                if (diceNumber == 1){
//                    player2.getGameScore().takeScore(player1.getGameScore()
//                            , Steal_Score);
//                    break;
//                }

            case Buff:
                if (diceNumber == 3){
                    player1.getGameScore().addScore(Buff_Score);
                    break;
                }

            case Death:
                if (diceNumber == 4){
                    player1.getGameScore().loseScore(Death_Score);
                    break;
                }

        }

    }
}
