package homework.homework5;
import java.util.ArrayList;

public class Player {
    int playerNumber; //플레이어번호
    String name; //이름
    int cardsCount; //가진 카드 개수
    ArrayList<Integer> cards; //가진 모든 랜덤카드 (배열)

    Player(int playerNumber, String name, int cardsCount){
        this.playerNumber = playerNumber;
        this.name = name;
        this.cardsCount = cardsCount;
    }

    public void setCards(ArrayList<Integer> cards) {
        this.cards = cards;
    }


    public int getCardsCount() {
        return cardsCount;
    }


    @Override
    public String toString() {
        return "플레이어" + playerNumber +
                ":" + name +
                ", cards=" + cards;
    }

    public void cards(ArrayList<Integer> arrayCards) {
    }
}

