package homework4;

public class CardPrint {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame("김진호");
        cardGame.addCard("A");
        cardGame.addCard("2");
        cardGame.addCard("3");
        cardGame.addCard("4");
        cardGame.addCard("5");
        cardGame.addCard("6");
        cardGame.addCard("7");
        cardGame.addCard("8");
        cardGame.addCard("9");
        cardGame.addCard("J");
        cardGame.addCard("Q");
        cardGame.addCard("K");

        cardGame.cardInfo();
    }
}
