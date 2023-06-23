package homework.fifth.review.strange;


import java.util.ArrayList;
import java.util.List;

public class PatternReviewTest {
    public static void main(String[] args) {
        List<Card2> cardList = new ArrayList<>();

        for (CardPattern2 pattern: CardPattern2.values()) {
            cardList.add(new Card2(pattern));
        }

        System.out.println(cardList);
    }
}
