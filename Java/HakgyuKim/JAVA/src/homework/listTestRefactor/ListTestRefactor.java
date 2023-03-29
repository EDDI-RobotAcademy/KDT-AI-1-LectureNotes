package homework.listTestRefactor;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;


public class ListTestRefactor {
    public static void main(String[] args) {
        final int CARD_NUM_MAX = 13;
        List<String> cards = new ArrayList<>();


        for(int i = 0; i < CARD_NUM_MAX; i++) {
           cards.add(i, CardPattern.checkPatternByIndex(i));
        }

        System.out.println(cards);

        List<String> pokerHand = new ArrayList<>();
        final int CARD_HAND_NUM = 5;
        for (int i = 0; i < CARD_HAND_NUM; i++) {
            pokerHand.add(cards.get(CustomRandom.generateNumber(CARD_HAND_NUM)));

        }
        System.out.println(pokerHand);
    }
}
