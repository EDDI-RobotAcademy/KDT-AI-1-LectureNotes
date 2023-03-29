package homework.fifth.review.strange;

public class Card2 {

    final private CardPattern2 cardPattern;

    public Card2(CardPattern2 cardPattern) {
        this.cardPattern = cardPattern;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardPattern=" + cardPattern +
                '}' + '\n';
    }
}
