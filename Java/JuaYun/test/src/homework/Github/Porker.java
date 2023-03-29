package homework.Github;

import java.util.ArrayList;

class Card1 {
    // 클래스에 CardNum이라는 객체를 생성해주고 생성자와 toString을 생성
    String CardNum;

    public Card1(String cardNum) {
        this.CardNum = cardNum;
    }

    @Override
    public String toString() {
        return "card1{" +
                "CardNum='" + CardNum + '\'' +
                '}';
    }
}
public class Porker {

    // Porke안에 Card1에 있는 CardNum배열을 생성
    final static String[] CardNum = {"A", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "J", "Q", "K"};

    // psvm을 선언한후 ArrayList를 생성하여 새로운 이름을 설정
    public static void main(String[] args) {
        ArrayList<Card1> cardList = new ArrayList<>();

        // foreach
        for(String CardNum: CardNum) {
            Card1 card1 = new Card1(CardNum);
            cardList.add(card1);
        }
        System.out.println(cardList);
    }
}
