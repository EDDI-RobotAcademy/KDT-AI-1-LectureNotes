package homework.fifth.review;

import java.util.ArrayList;
import java.util.List;

public class EnumListTest {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>(); //  cards는 List<card>의 리스트이다.
        for(int i =0; i<12; i++){ //12가 아니면 갯수가 맞지 않아서 에러가 나는 듯?
            cards.add(new Card(CardPattern.checkPatternByIndex(i)));
        }
        System.out.println(cards);

    }
}
