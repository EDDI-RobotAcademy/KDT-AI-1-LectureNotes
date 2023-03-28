package list;

import java.util.Arrays;


class Card {

    final private String[] cardNumber={"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};


    public String[] getCardNumber() {
        for (int i = 0; i < cardNumber.length; i++) {
            System.out.println("카드: " + cardNumber[i]);
        }
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + Arrays.toString(cardNumber) +
                '}';
    }
}

public class ListQuiz1 {
        public static void main(String[] args) {
            final Card cardNumber = new Card();
            System.out.println(cardNumber.getCardNumber());

        }
    }
