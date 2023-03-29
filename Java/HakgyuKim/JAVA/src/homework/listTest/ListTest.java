package homework.listTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

class PokerCard {
    String[] pokerCard = {"A", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "J", "Q", "K"};

    public PokerCard() {
        this.pokerCard = pokerCard;
    }

    public String getPokerCard(int i) {
        return pokerCard[i];
    }
}

public class ListTest {
    public static void main(String[] args) {
        PokerCard pokercard = new PokerCard();
        final int MAX = 12;
        final int POKER_HAND_SIZE = 5;
        List<String> pokerHand = new ArrayList<>();

        for (int i = 0; i <POKER_HAND_SIZE; i++) {
            pokerHand.add(pokercard.getPokerCard(CustomRandom.generateNumber(MAX)));
        }
        System.out.println(pokerHand);
    }
    }


