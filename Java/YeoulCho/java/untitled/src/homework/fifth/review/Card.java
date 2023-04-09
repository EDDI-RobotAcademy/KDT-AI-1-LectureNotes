package homework.fifth.review;

public class Card {
    final private CardPattern cardPattern; // 멤버변수에 CardPattern cardPattern 넣겠다.

    public Card(CardPattern cardPattern) {
        this.cardPattern = cardPattern;
    }

    @Override //카드 안의 내용 보고 싶으면 toString
    public String toString() {
        return "Card{" +
                "cardPattern=" + cardPattern +
                '}'+ '\n';
    }
}
