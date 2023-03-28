package homework.fifth.cardTest;

import homework.fifth.cardTest.Card;

import java.util.ArrayList;
import java.util.List;

public class CardListTest {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("A"));
        cards.add(new Card("1"));
        cards.add(new Card("2"));
        cards.add(new Card("3"));
        cards.add(new Card("4"));
        cards.add(new Card("5"));
        cards.add(new Card("6"));
        cards.add(new Card("7"));
        cards.add(new Card("8"));
        cards.add(new Card("9"));
        cards.add(new Card("J"));
        cards.add(new Card("Q"));
        cards.add(new Card("K"));

        System.out.println(cards);
    }

}
