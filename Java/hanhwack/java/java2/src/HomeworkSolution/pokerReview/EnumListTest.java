package HomeworkSolution.pokerReview;

import java.util.ArrayList;
import java.util.List;

public class EnumListTest {
    public static void main(String[] args) {
        final int MAX_CARD_NUMBER = 12 ;
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
            cards.add(new Card(CardPattern.checkPatternByIndex(i)));
        }
        System.out.println(cards);
    }
}
