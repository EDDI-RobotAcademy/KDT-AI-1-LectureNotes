package _homework_04_01_review;


//enum을 활용한 카드 리스트 문제 리팩토링 [ENUM-LISTx]


import java.util.ArrayList;
import java.util.List;

public class EnumListTest {
    public static void main(String[] args) {
        final int MAX_CARD_NUMBER = 12;

        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
            cards.add(new Card(CardPattern.checkPatternByIndex(i)));
        }

        System.out.println(cards);
    }
}