package homework;

import utility.random.CustomRandom;
import java.util.ArrayList;
import java.util.List;

class Card {
    List<Integer> cardList;
    public Card() {
        cardList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            cardList.add(CustomRandom.generateNumber(1,12));
        }
        }

    public Card(List<Integer> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardList=" + cardList +
                '}';
    }
}
public class TestCard {
//    public static void main(String[] args) {
//
//
//    List<Integer> cardList = new ArrayList<>();
//
//    for (int i = 0; i < 2; i++) {
//        cardList.add(CustomRandom.generateNumber(1, 12));
//
//        if (cardList.get(i) == 1) {
//            System.out.println("A");
//        }
//
//        else if (cardList.get(i) == 10) {
//            System.out.println("J");
//        }
//
//        else if (cardList.get(i) == 11) {
//            System.out.println("Q");
//        }
//
//        else if (cardList.get(i) == 12) {
//            System.out.println("K");
//        } else {
//            System.out.println(cardList.get(i));
//        }
//    }
//    }

    public static void main(String[] args) {

        List<Card> cardList = new ArrayList<>();

//        if (cardList.get(i) == 1) {
//            System.out.println("A");
//        }
//
//        else if (cardList.get(i) == 10) {
//            System.out.println("J");
//        }
//
//        else if (cardList.get(i) == 11) {
//            System.out.println("Q");
//        }
//
//        else if (cardList.get(i) == 12) {
//            System.out.println("K");
//        } else {
//            System.out.println(cardList.get(i));
        }

    }



