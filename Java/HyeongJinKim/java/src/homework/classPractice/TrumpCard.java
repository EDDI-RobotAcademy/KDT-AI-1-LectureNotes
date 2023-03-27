package homework.classPractice;

import java.util.ArrayList;
import java.util.List;

class Cards {
    final int CARD_ACE = 0;
    final int CARD_JACK = 11;
    final int CARD_QUEEN = 12;
    final int CARD_KING = 13;
    final int CARD_SCALE = 14;
    List<String> cards;

    public Cards() {
        cards = new ArrayList<>();
        for (int i = 0; i < CARD_SCALE; i++) {
            switch (i) {
                case CARD_ACE:
                    cards.add("A");
                    break;
                case CARD_JACK:
                    cards.add("J");
                    break;
                case CARD_QUEEN:
                    cards.add("Q");
                    break;
                case CARD_KING:
                    cards.add("K");
                    break;
                default:
                    cards.add(String.valueOf(i + 1));
                    break;
            }
        }
    }
}
public class TrumpCard {
    public static void main(String[] args) {
        Cards cards = new Cards();
        System.out.print(cards.cards);
    }
}
