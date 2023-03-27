package homework;
import java.util.Arrays;
import java.util.stream.Stream;

// Stream을 통한 처리 방법
class Game2 {

    final private int MAX_DICE = 4;
    final private Dice3[] diceArray;
    final private Score2 score;

    public Game2() {
        // Stream.generate(Dice3::new)는
        // Dice3 객체의 생성자를 호출함을 의미합니다.
        // .limit(MAX_DICE)를 통해서 생성하는 개수를 4개로 제한합니다.
        // 아직 List를 배우지 않았으므로 배열로 바꿔야해서
        // toList().toArray를 통해 강제로 Dice3 타입의 배열로 만듭니다.
        diceArray = Stream.generate(Dice3::new).
                limit(MAX_DICE).toList().
                toArray(new Dice3[0]);

        // 위에서 만든 diceArray를 개별적 요소로 분해합니다.
        // Arrays.stream(diceArray).mapToInt(elem 까지의 내용입니다.
        // 여기서 elem은 분해된 각 diceArray의 요소이고
        // 이 요소는 Dice3 객체에 해당하므로
        // elem.getDiceNumber()를 통해 주사위 값을 확보합니다.
        // 이후 만들어진 배열(4개)에서 모든 주사위의 값을 sum()을 통해 합칩니다.
        score = new Score2(
                Arrays.stream(diceArray).
                        mapToInt(elem -> ((Dice3) elem).getDiceNumber()).sum());
    }

    public Boolean checkWin () {
        return score.checkWin();
    }

    @Override
    public String toString() {
        return "Game{" +
                "diceArray=" + Arrays.toString(diceArray) + '\n' +
                ", score=" + score +
                '}';
    }
}

class Dice3 {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public Dice3() {
        this.diceNumber = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}

class Score2 {
    final private int WIN_DECISION1 = 3;
    final private int WIN_DECISION2 = 4;
    final private int totalScore;

    public Score2(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }

    public Boolean checkWin () {
        if ((totalScore % WIN_DECISION1 == 0) ||
                (totalScore % WIN_DECISION2 == 0)) {

            return true;
        }

        return false;
    }
}

public class Dice {
    public static void main(String[] args) {
        Game2 game = new Game2();
        System.out.println(game);
        System.out.println(game.checkWin() ? "승리!" : "패배!");
    }

}
