package customLibrary;
//총 12개의 값을 출력할 수 있는 12면체 주사위를 만들어 봅시다.
public class Dice {
    final private int MIN = 1;
    final private int MAX = 12;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = (int)(Math.random()* MAX - MIN + 1) +MIN;
    }

    public int getDiceNumber() {
        return diceNumber;
    }
}
