package homework.homework5;

import java.util.Arrays;

public class Player {
    int playerNumber;
    String name;
    static int cardsCount;
    int[] cards;

    Player(int playerNumber, String name, int cardsCount){
        this.playerNumber = playerNumber;
        this.name = name;
        this.cardsCount = cardsCount;
    }

    public Player(int[] cards) {
        this.cards = cards;
    }


    public int[] getCards() {
        return cards;
    }

    public void setCards(int[] cards) {
        this.cards = cards;
    }

    public static int getCardsCount() {
        return cardsCount;
    }

    public void divideCards() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", name='" + name + '\'' +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }
}
