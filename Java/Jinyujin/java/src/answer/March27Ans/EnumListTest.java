package answer.March27Ans;

import java.util.ArrayList;
import java.util.List;

public class EnumListTest {

    public static void main(String[] args) {

        int MAX_CARD_NUMBER = 12;

        List<Card> CardList = new ArrayList<>();

        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
            Card card = new Card(CardPattern.checkPatternByIndex(i));
            CardList.add(card);
        }

        System.out.println(CardList);
    }
}
