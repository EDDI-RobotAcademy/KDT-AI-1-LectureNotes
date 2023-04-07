package homework.cardex;

import java.util.ArrayList;
import java.util.List;

public class EnumTest {
    public static void main(String[] args) {
        // 카드의 총 갯수
        final int MAX_CARD_NUMBER = 12;
        // Cardex의 클래스를 가져와 리스트를 생성
        List<Cardex> cardexs = new ArrayList<>();

        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
            cardexs.add(new Cardex(CardPattern.checkPatternByIndex(i)));
        }
        System.out.println(cardexs);
    }
}
