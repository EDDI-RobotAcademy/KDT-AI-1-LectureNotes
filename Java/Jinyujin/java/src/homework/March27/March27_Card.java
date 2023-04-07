package homework.March27;

import java.util.ArrayList;
import java.util.List;

public class March27_Card {
    String[] cardName = new String[]{
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

    List<String> cardList = new ArrayList<>(List.of(cardName));

    @Override
    public String toString() {
        return "March27_Card{" +
                "cardList=" + cardList +
                '}';
    }
}
