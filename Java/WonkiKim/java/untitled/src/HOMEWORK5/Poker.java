package HOMEWORK5;

import java.util.ArrayList;

class Card{
    String cardNumber;

    public Card(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
public class Poker {
    final static String[] cardNumber = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public static void main(String[] args) {
        ArrayList<Card> cardSet = new ArrayList<>();
        for (String cardNumber: cardNumber) {
            Card card = new Card(cardNumber);
            cardSet.add(card);
        }
        System.out.println(cardSet);
    }
}
