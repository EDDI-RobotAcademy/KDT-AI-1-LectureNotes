package homework.fourth.card;

import java.util.ArrayList;
import java.util.List;

class Card{
    final int CARD_ACE = 1;
    final int CARD_JACK = 11;
    final int CARD_QUEEN = 12;
    final int CARD_KING = 13;
    final int CARD_NUM = 13;
    List<String> card = new ArrayList<>();

    public Card() {
        for(int i = 1; i <= CARD_NUM; i++ ){
           switch(i){
               case CARD_ACE:
                   card.add("A");
                   break;
               case CARD_JACK:
                   card.add("J");
                   break;
               case CARD_QUEEN:
                   card.add("Q");
                   break;
               case CARD_KING:
                   card.add("K");
                   break;
               default:
                   card.add(String.valueOf(i));
                   break;
           }
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "card=" + card +
                '}';
    }
}
public class FourthHomeworkListCard {
    public static void main(String[] args) {
        Card card = new Card();
        System.out.println(card);
    }
}
