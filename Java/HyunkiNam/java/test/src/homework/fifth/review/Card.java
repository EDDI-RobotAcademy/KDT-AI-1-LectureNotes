package homework.fifth.review;

import java.util.List;

public class Card {

    final private CardPattern cardPattern;

    public Card(CardPattern cardPattern){
        this.cardPattern = cardPattern;
    }

    @Override
    public String toString() {
        return "{" + cardPattern.getName() + '}';
    }


}
