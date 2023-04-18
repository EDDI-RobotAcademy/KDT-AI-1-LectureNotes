package Card;

import java.util.ArrayList;
import java.util.List;

public class enumListTest {
    public static void main(String[] args) {
        final int MAX_CARD_NUMBER = 12;
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
            // new 새로운 객체를 만듬
            // enum으로 만들어둔 CardPattern
            cards.add(new Card(CardPattern.checkPatternByIndex(i)));
        }

        System.out.println(cards);
    }

}

