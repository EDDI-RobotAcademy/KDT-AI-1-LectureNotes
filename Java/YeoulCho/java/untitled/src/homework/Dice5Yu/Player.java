package homework.Dice5Yu;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Dice> diceList = new ArrayList<>();
    String name;

    Score score;


    public Player() {
        this.diceList = diceList;
        this.name = name;
        score = new Score();
    }


    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "플레이어 : " +
                "diceList=" + diceList +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}' + '\n';
    }



}

