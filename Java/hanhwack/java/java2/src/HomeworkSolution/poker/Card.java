package HomeworkSolution.poker;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List <String> cardList = new ArrayList<>() ;
    public Card() {
        String number = "" ;
        for (int i = 0; i < 12; i++) {
            if (i > 0 && i < 9) {
                number = String.valueOf(i+1);
            } else if (i == 10) {
                number = String.valueOf((char) (i + 71));
            } else if (i == 11){
                number = String.valueOf((char) (i + 64));
            } else {
                number = String.valueOf((char) (i + 65));
            }

            cardList.add(i, number);
        }
    }

    public void getCard() {
        for(String data: cardList){
            System.out.println(data);
        }

    }
}
