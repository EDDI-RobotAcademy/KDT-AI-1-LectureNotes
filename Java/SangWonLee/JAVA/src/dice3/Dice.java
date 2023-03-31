package dice3;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    int START = 0;
    int diceDog = 3; // 주사위 갯수
    int diceJJak = 2; // 짝수 일 때 쓰일 숫자.
    int MAX_Dice = 6;
    int MIN_Dice = 1;

    List<Integer> dice = new ArrayList<>();
//    List<List<Integer>> twoDice = new ArrayList<>();


    public List<Integer> rollDice() {
//        for (int j = 0; j < 2; j++) {
            dice.clear();
            for (int i = START; i < diceDog; i++) {

                dice.add(Custom_Random.generateNumber(MIN_Dice,MAX_Dice));
                if (dice.get(0) % diceJJak == 0) {
                    dice.add(0);
                    dice.add(0);
                    break;
                }

            }
//            twoDice.add(dice);
//        }

//        System.out.println(twoDice);
        

        return dice;
    }
}
