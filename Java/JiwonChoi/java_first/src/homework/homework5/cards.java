package homework.homework5;

import utility.random.CustomRandom;

import static homework.homework5.Player.getCardsCount;

public class cards {
    static int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static int[] arrayCards = new int[10];

    static int randomCardNum() {
        int randomCardNum = CustomRandom.generateNumber(1, 12);
        return randomCardNum;
    }

    static void divideCards() {

        for (int i = 0; i < getCardsCount(); i++) {
            arrayCards[i] = randomCardNum();
//            System.out.println(arrayCards[i]);
        }
    }

    public static void main(String[] args) {

    }

}