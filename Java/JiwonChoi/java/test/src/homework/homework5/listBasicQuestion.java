package homework.homework5;

import java.util.ArrayList;

public class listBasicQuestion {
    public static void main(String[] args) {
        Player player1 = new Player(1, "김땡땡", 2); //플레이어 정보
        Player player2 = new Player(2, "이땡땡", 7);

        ArrayList<String> arrayCards1 = new ArrayList<>();
        player1.cards(arrayCards1);
        cards.divideCards(arrayCards1, player1.getCardsCount()); //여러번 랜덤카드를 뽑는 함수


        player1.setCards(arrayCards1); //뽑은 랜덤카드배열을 player1의 Cards에 저장

//         for(int i = 0; i < player1.cardsCount; i++) {
//             int cardnum = player1.cards[i];
//             String[] realCard = new String[player1.cardsCount];
//             realCard[i] = CardsPattern.patternValueList[cardnum-1].cardName;
//         }

        // player1.card[0] -->9
        //int cardnum = player1.card[0]
        // realCard[0] = CardPattern.patternValueList[cardnum-1].cardName -->카드이름 "9"

        System.out.println(player1); //player1 정보 출력



        ArrayList<Integer> arrayCards2 = new ArrayList<>();
        player2.cards(arrayCards2);
        cards.divideCards(arrayCards2, player2.getCardsCount());
        player2.setCards(arrayCards2); //뽑은 랜덤카드배열을 player2의 Cards에 저장
        System.out.println(player2); //player2 정보 출력

    }

}
