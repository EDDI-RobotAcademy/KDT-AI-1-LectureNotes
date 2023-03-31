package homework.fifth;

import java.util.ArrayList;
import java.util.List;

public class EnumListTest {
    public static void main(String[] args) {
        final int MAX_CARD_NUMBER=12;
        List<ReCard> cards = new ArrayList<>();
        for (int i=0; i<MAX_CARD_NUMBER;i++){
            cards.add(new ReCard(CardPattern.checkPatternIndex(i)));
        }
        System.out.println(cards);
    }
}
