package examSolve.exam1.customLibrary.diceGame;

// 문제 28번
// 총 10명의 플레이어가 주사위를 굴릴 수 있게 만들어 봅시다.
public class Player implements Comparable<Player>{
    private String name;
    private final Dice dice;

    public Player(String name) {
        this.name = name;
        this.dice = new Dice();
    }

    public String getName() {
        return name;
    }

    public Dice getDice() {
        return dice;
    }

    // 나와 다른 플레이어의 주사위 값을 비교할 것이다.
    // 나의 주사위 값이 다른 플레이어의 값보다 크면 1을 반환
    // 나의 주사위 값이 다른 플레이어의 값보다 작으면 -1을 반환
    //
    @Override
    public int compareTo(Player otherPlayer) {
        final int otherPlayerDiceNumber = otherPlayer.getDice().getDiceNumber();
        final int currentPlayerDiceNumber = this.getDice().getDiceNumber();

        if (otherPlayerDiceNumber < currentPlayerDiceNumber) {
            return 1;
        } else if (otherPlayerDiceNumber > currentPlayerDiceNumber) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dice=" + dice +
                '}' + '\n';
    }
}
