package homework.fifth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {

    List<String> cardList;
    List<String> cardList2;
    String[] cardArray = {"A","2","3","4","5","6","7","8","9","10"
            ,"J","Q","K"};
    public Card(){
        cardList = new ArrayList<>(Arrays.asList("A","2","3","4","5","6","7","8","9","10"
                ,"J","Q","K"));
        cardList2 = new ArrayList<>(Arrays.asList(cardArray));

    }

    @Override
    public String toString() {
        return "cardList=" + cardList + "\n" +
                "cardList2=" + cardList2;
    }
}
