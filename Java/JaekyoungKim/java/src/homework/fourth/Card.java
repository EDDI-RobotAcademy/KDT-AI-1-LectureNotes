package homework.fourth;

import utilityRandom.CustomRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    String cardValue;
    final private int PLAYER_NUM;

    List<String> cardDeck=new ArrayList<>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
    final int MAX=12;
    final int MiN=0;

    public Card(int PLAYER_NUM){
        this.PLAYER_NUM=PLAYER_NUM;
        this.cardValue =cardDeck.get(CustomRandom.generateNumber(MiN,MAX));
    }

    @Override
    public String toString() {
        return "사용자 "+PLAYER_NUM+"이 뽑은 카드는 " + cardValue+" 입니다."
                ;
    }
}

