package homework.sixth.practice;

public class Player {
    final private Dice dice = new Dice();
    final private Score score = new Score();
    final private String name;

    public Player(String name) {
        this.name = name;
    }

    // 주사위 굴리기
    public int rollDice() {
        return dice.draw();
    }

    public Score getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

}