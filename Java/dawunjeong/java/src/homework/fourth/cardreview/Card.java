package homework.fourth.cardreview;

public class Card {

    final private CardPattern cardPattern;

    public Card(CardPattern cardPattern) {
        this.cardPattern = cardPattern;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardPattern=" + cardPattern +
                '}' + '\n';
    }
}