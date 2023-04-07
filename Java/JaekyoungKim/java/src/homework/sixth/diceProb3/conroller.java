package homework.sixth.diceProb3;

public class conroller {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        System.out.println("점수 판정 이후");
        gameManager.playGame();
        gameManager.printResult();
        gameManager.checkWinner();
    }
}
