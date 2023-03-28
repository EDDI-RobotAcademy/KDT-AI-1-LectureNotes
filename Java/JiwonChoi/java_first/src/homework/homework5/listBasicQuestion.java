package homework.homework5;

import static homework.homework5.cards.arrayCards;

public class listBasicQuestion {
    public static void main(String[] args) {
        Player player1 = new Player(1, "김땡땡", 5);
        Player player2 = new Player(2, "이땡땡", 6);

        cards.divideCards();
        player1.setCards(arrayCards);
        System.out.println(player1.toString());

        cards.divideCards();
        player2.setCards(arrayCards);
        System.out.println(player2.toString());

    }

}
