package TEST.card_uebung;

import utility.random.CustomRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSpiel {
    char[] cardnum = new char[]{'A','2','3','4','5','6','7','8','9','J','Q','K'};
    char[] cardform = new char[] {'◆', '♣', '♥','♠'};
    List<Character> CardList;
    List<String> CardTakeList;

    public CardSpiel() {
        CardTakeList = new ArrayList<>();
        CardList = new ArrayList<>();
        this.cardnum = cardnum;
        this.CardList = CardList;
        this.cardform = cardform;
    }

    public void cardlistnum() {
        for (char cardn : cardnum)
            CardList.add(cardn);
    }


    public void cardtake() {
        final int TAKE_CARD_NUM = 5;
        final int TAKE_CARD_FORM = 4;
        cardlistnum();
        for (int i = 0; i < TAKE_CARD_NUM; i++) {
            int RandomNum_Index = CustomRandom.generateNumber((TAKE_CARD_NUM-1));
            int RandomForm_Index = CustomRandom.generateNumber((TAKE_CARD_FORM-1));
            String card = String.valueOf(cardform[RandomForm_Index]) + CardList.get(RandomNum_Index);
            CardTakeList.add(card);
            CardList.remove(RandomNum_Index);
            }
        System.out.println(CardTakeList);

    }
    @Override
    public String toString() {
        return "CardSpiel{" +
                "CardTakeList=" + CardTakeList +
                '}';
    }
}






