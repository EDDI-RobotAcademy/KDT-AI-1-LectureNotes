package homework.DiceYu;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Dice> diceList = new ArrayList<>();
    String name;

    Score score;


    public Player(String name) {
        this.diceList = diceList;
        this.name = name;
        score = new Score();
    }

    public void rollDice() {
        final int NumberOfDice = 3;

        for (int i = 0; i < NumberOfDice; i++) {
            Dice d1 = new Dice();
            d1.randomDiceNumber();
            diceList.add(d1);
            score.setTotalScore(score.getTotalScore() + diceList.get(i).getDiceNumber());
            if (diceList.get(0).getDiceNumber() % 2 == 0) {
            } else {
                break;
            }


        }
    }

    @Override
    public String toString() {
        return "플레이어 : " +
                "diceList=" + diceList +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public void calculateTotalScore(Score targetScore) {
        if (diceList.size() == 3) {
            switch (diceList.get(2).getDiceNumber()) {
                case 1: {
                    score.totalScore += 3;
                    targetScore.totalScore -=3;
                    break;
                }
                case 3: {
                    score.totalScore += 2;
                    break;
                }
                case 4: {
                    score.totalScore -= 77777;
                    break;
                }

            }
        }
    }
}

