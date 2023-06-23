package review1.reviewTestCode;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class TemporaryPlayer {
    private List<Integer> integerList;
    private String playerName;

    public TemporaryPlayer() {
        this.integerList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            integerList.add(CustomRandom.generateNumber(1, 6));
        }
    }

    public void playerAdd (String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "TemporaryPlayer{" +
                "integerList=" + integerList +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
