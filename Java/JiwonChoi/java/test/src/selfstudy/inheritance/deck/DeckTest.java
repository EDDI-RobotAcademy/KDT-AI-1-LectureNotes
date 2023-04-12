package selfstudy.inheritance.deck;

public class DeckTest {
    public static void main(String[] args) {
        Deck deck1 = new Deck();
        Card pickedCard = deck1.pick(0); //맨 윗장 카드
        System.out.println(pickedCard);

        deck1.shuffle();
        pickedCard = deck1.pick(0);
        System.out.println(pickedCard);

        deck1.shuffle();
        pickedCard = deck1.pick(0);
        System.out.println(pickedCard);
    }

}
