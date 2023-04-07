package list;


import java.util.ArrayList;
import java.util.List;

class Card2{
    String cardNumber;

    public Card2(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card2{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }
}

public class ListBasicQuiz {

    public static void main(String[] args) {
        List<Card2> cardList = new ArrayList<>(); //cardList는 card2의 List이다.
        String[] cardNumber = {"A","2","3","4","5","6","7","8", "9","J","Q","K"}; // String 배열 cardNumber는 다음과 같다.

        //foreach 배열 안에 저장되어 있는 데이터를 for문에서 순차적으로 꺼내서 : 왼쪽에 있는 변수에 담아주는 흐름
        for (String cardName: cardNumber // 문자형 cardName에 cardNumber를 하나씩 할당하겠다.
             ) {
            Card2 card = new Card2(cardName);// Card2의 card에 cardName을 넣겠다.
            cardList.add(card); //cardList에 카드를 추가 하겠다.
        }
        System.out.println(cardList); // 카드리스트를 출력해라.

    }

}
