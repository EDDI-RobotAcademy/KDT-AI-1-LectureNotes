package homework4;

public class CardPrint {
    public static void main(String[] args) {
        CardGame cardGame1 = new CardGame("김진호");
        cardGame1.addCard("A");
        cardGame1.addCard("2");
        cardGame1.addCard("3");
        cardGame1.addCard("4");
        cardGame1.addCard("5");
        cardGame1.addCard("6");
        cardGame1.addCard("7");
        cardGame1.addCard("8");
        cardGame1.addCard("9");
        cardGame1.addCard("J");
        cardGame1.addCard("Q");
        cardGame1.addCard("K");

        cardGame1.cardInfo();
    }
}
