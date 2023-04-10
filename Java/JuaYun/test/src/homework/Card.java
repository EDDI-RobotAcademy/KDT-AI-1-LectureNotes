package homework;

import utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public static void main(String[] args) {
        String[] card = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
        List<String> cardList = new ArrayList<String>();

        int cardLength = card.length;  // int로 한번 변환시켜주는 작업인거 같음
        for (int i = 0; i < 2; i++) {

            // 문자열을 정수형태로 받아 뽑기위한 작업
            int tmpIndex = CustomRandom.generateNumber(0, cardLength);
            cardList.add(card[tmpIndex]);
            //cardList.add(card[CustomRandom.generateNumber(0, cardLength)]);
            System.out.println("출력: " + cardList.get(i));
        }
    }
}
