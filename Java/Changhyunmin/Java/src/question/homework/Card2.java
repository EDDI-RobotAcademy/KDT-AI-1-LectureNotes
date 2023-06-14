package question.homework;

import java.util.ArrayList;
public class Card2 {
    public int CardValue = 13;
    ArrayList<String>CardNum = new ArrayList<>();
    public void cardList() {
        for (int i = 0; i < CardValue; i++) {
        }

        CardNum.add("A");
        CardNum.add("2");
        CardNum.add("3");
        CardNum.add("4");
        CardNum.add("5");
        CardNum.add("6");
        CardNum.add("7");
        CardNum.add("8");
        CardNum.add("9");
        CardNum.add("10");
        CardNum.add("J");
        CardNum.add("Q");
        CardNum.add("K");
    }
    @Override
    public String toString() {
        return "트럼프 카드: " + CardNum;
    }
}

