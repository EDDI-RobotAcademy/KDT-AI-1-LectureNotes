package _homework_04_01;

import utility.random.CustomRandom;
import java.util.ArrayList;
import java.util.List;

class CardNumber{

    List<String> CardNumber;

    public CardNumber() {
        CardNumber = new ArrayList<>();
        CardNumber.add("A");
        CardNumber.add("1");
        CardNumber.add("2");
        CardNumber.add("3");
        CardNumber.add("4");
        CardNumber.add("5");
        CardNumber.add("6");
        CardNumber.add("7");
        CardNumber.add("8");
        CardNumber.add("9");
        CardNumber.add("J");
        CardNumber.add("Q");
        CardNumber.add("K");
    }

    public List<String> getCardNumber() {
        return CardNumber;
    }

}

public class Poker {
    public static void main(String[] args) {

        CardNumber card1 = new CardNumber();
        System.out.println("카드번호 출력: " + card1.getCardNumber());

    }
}
