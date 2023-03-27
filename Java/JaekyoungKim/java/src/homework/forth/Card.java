package homework.forth;

import utilityRandom.CustomRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    String cardValue;

    List<String> cardDeck=new ArrayList<>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
    final int MAX=12;
    final int MiN=0;

    public Card() {
        this.cardValue =cardDeck.get(CustomRandom.generateNumber(MiN,MAX));
    }

    @Override
    public String toString() {
        return "당신이 뽑은 카드는 " + cardValue+" 입니다."
                ;
    }
}

