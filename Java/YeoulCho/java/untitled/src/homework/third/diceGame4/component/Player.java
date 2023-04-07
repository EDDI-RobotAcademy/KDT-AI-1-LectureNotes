package homework.third.diceGame4.component;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
//    private List<GameDice[]> gameDicesList = new ArrayList<GameDice[]>();

    public Player (String name){
        this.name = name;

        int diceNumberSum = rollDice();
       // gamescore = new GameScore(diceNumberSum);
    }

    private int rollDice(){
        int diceNumberSum = 0;
        final int FIRST_DICE_INFO =0;
        final int DECISION_EVEN = 2; //짝수냐? 나눌때 묻기위한 숫자
        final int ODD = 1;



        for(int i =0; i<MAX_DICE_NUM; i++){
            diceNumberSum = gameDices[i].getDiceNumber();
            if(gameDices[FIRST_DICE_INFO].getDiceNumber() % DECISION_EVEN == ODD){
                break;
            }
        }
        return diceNumberSum;
    }

}
