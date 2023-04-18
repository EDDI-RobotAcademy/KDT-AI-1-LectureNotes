package selfstudy.inheritance.deck;


import utility.random.CustomRandom;


class Card {
    static final int CARD_KIND_MAX =4;
    static final int CARD_NUM_MAX =13;

    static final int CARD_KIND_SPADE =4;
    static final int CARD_KIND_DIAMOND =3;
    static final int CARD_KIND_HEART =2;
    static final int CARD_KIND_CLOVER =1;

    int cardKind;
    int cardNumber;

    public Card(int cardKind, int cardNumber) {
        this.cardKind = cardKind;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
                String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
                String numbers = "0123456789XJQK";
                return  "카드 모양 : " + kinds[this.cardKind] + '\n' +
                        "카드 번호 : " + numbers.charAt(this.cardNumber);

    }
}

public class Deck {
    final int CARDS_NUM = 52;
    Card cardsArray[] = new Card[CARDS_NUM]; //Card 객체 배열을 >>포함<<

    public Deck() {
        int i = 0;
        for(int k = Card.CARD_KIND_MAX; k > 0; k--){
            for(int n = 0; n < Card.CARD_NUM_MAX; n++){
                cardsArray[i++] = new Card(k, n+1);
            }
        }
    }
    Card pick(int index){
        return cardsArray[index];
    }

    Card pick() {
        int index = CustomRandom.generateNumber(1, CARDS_NUM);
        return pick(index);
    }

    void shuffle() {
        for(int i = 0; i < cardsArray.length; i++){
            int tmpIndex1 = CustomRandom.generateNumber(CARDS_NUM-1);
            int tmpIndex2 = CustomRandom.generateNumber(CARDS_NUM-1);
            cardsArray[i] = cardsArray[tmpIndex1];
            cardsArray[tmpIndex1] =  cardsArray[tmpIndex2];
        }
    }

}

