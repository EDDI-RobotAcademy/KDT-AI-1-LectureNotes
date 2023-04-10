package homework4;

import java.util.ArrayList;

public class CardGame {
    String usage;
    ArrayList<Card> cardList;

    public CardGame(String usage) {
        this.usage = usage;
        cardList = new ArrayList<Card>();
    }

    public void addCard(String cardNum){
        Card card = new Card();
        card.setCardName(cardNum);
        cardList.add(card);
    }

    public void cardInfo() {
        for (Card c: cardList) {
            System.out.println("사용자:" + usage + "  " + "카드: " + c.getCardName());
        }
    }
}
