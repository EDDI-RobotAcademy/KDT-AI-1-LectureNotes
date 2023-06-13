package newdice;

class specialDice{
    Player1 player1 = new Player1("민");
    Player1 player2 = new Player1("훈");

    Die die = new Die();

    public void chackWinner(){
        GameScore firstPlayerScore = player1.getGameScore();
        GameScore secondPlayerScore = player2.getGameScore();

        final int firstPlayerTotalScore = firstPlayerScore.getTotalScore();
        final int secondPlayerTotalScore = secondPlayerScore.getTotalScore();

        if (firstPlayerTotalScore > secondPlayerTotalScore) {
            System.out.println("승자: " + player1.getName());
            return;
        }
        if (firstPlayerTotalScore < secondPlayerTotalScore) {
            System.out.println("승자: " + player2.getName());
            return;
        }
        else {
            System.out.println("무승부");
        }
    }
}

public class Dice{
    public static void main(String[] args) {
        Die die = new Die();
        System.out.println(die);
    }
}
