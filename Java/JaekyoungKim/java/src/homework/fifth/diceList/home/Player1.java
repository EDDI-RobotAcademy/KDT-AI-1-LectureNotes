package homework.fifth.diceList.home;

import homework.third.GameDice;
import homework.third.GameScore;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Player1 {
    final private int MAX_DICE_NUM=3;
    final private String name;
    List<GameDice> gameDice=new ArrayList<>();
    final private GameScore gameScore;

    public Player1(String name) {
        int diceNumberSum=rollDice();
        gameScore=new GameScore(diceNumberSum)
    }
    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;
        int diceNumberSum = 0;
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDice.set(i, new GameDice());
            diceNumberSum += gameDice.get(i).getDiceNumber();
            if (gameDice.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }
}}
