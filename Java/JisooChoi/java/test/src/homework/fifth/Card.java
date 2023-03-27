package homework.fifth;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List<String> cardList; // List 선언

    public Card(){
        cardList = new ArrayList<>(); // List 생성
    }

    public void addCardList(){
        final int CARD_NUMBER = 12;

        String[] cardArr = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

        for(int i = 0; i < CARD_NUMBER; i++){
            cardList.add(cardArr[i]); // List 안에 값 추가
            //System.out.println(i+1+"번째 값: "+cardList.get(i));
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardList=" + cardList +
                '}';
    }
}
