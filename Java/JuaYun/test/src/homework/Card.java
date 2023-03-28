package homework;

import utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public static void main(String[] args) {
        String[] card = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
        List<String> cardList = new ArrayList<String>();

        for (int i = 0; i < 2; i++) {
            cardList.add(CustomRandom.generateNumber(0, 12));
            System.out.println("출력: " + cardList.get(i));
        }
    }
}
