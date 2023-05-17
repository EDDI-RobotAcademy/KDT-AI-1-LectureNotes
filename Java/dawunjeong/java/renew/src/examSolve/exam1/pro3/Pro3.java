package examSolve.exam1.pro3;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// 문제 3번
// A부터 J까지 카드를 리스트에 넣고 출력
class Card{
    // 카드는 A부터 시작하고,
    // Character 타입의 리스트를 만들어서 순차적으로 대입한다.
    final private char card = 'A';
    final private List<Character> cardList = new ArrayList<>();

    // 리스트는 Character 타입이므로 (char) 형변환을 해서 대입해준다.
    public Card() {
        for(int i = 0 ; i < 10; i++){
            cardList.add((char) (card + i));
        }
    }

    // 랜덤한 카드 찾기
    // 카드 리스트의 사이즈 -1을 한 숫자 중 랜덤한 인덱스를 뽑아서
    // 인덱스에 해당하는 카드 찾기
    public void findRandomCard(){
        final int MAX = cardList.size();
        final int LIST_BIAS = 1;
        int cardIdx = CustomRandom.generateNumber(MAX - LIST_BIAS);
        System.out.println(cardList.get(cardIdx));
    }
    @Override
    public String toString() {
        return "Card{" +
                "cardList=" + cardList +
                '}';
    }
}
public class Pro3 {
    public static void main(String[] args) {
        Card card = new Card();
        card.findRandomCard();
    }
}
