package TEST.card_uebung;

import utility.random.CustomRandom;
import java.util.ArrayList;
import java.util.List;

public class CardSpiel {
    String[] cardnum = new String[] {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    List<String> CardList;
    List<String> CardTakeList;

    public CardSpiel() {
        CardTakeList = new ArrayList<>();
        CardList = new ArrayList<>();
    }

    public void cardlist() {
        this.cardnum = cardnum;
        this.CardList = CardList;
        for (String cardn : cardnum)
            CardList.add(cardn);
    }

    public void cardtake() {
        int TAXE_CARD_NUM = 4;
        cardlist();
        for (int i = 0; i < TAXE_CARD_NUM; i++) {
            int RandomIndex = CustomRandom.generateNumber(CardList.size()-1);
            CardTakeList.add(CardList.get(RandomIndex));
            CardList.remove(RandomIndex);
            }
        System.out.println(CardTakeList);
    }


}





