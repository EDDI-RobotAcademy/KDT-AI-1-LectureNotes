package lectureClass;
class Dice {
    final int DICE_MAX = 6;
    final int DICE_MIN = 1;
    final int DICE_NUM;


    public Dice() {
        this.DICE_NUM = (int)(Math.random() * (DICE_MAX - DICE_MIN + 1)) + DICE_MIN;
    }

    public int getDICE_NUM() {
        return DICE_NUM;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "DICE_NUM=" + DICE_NUM +
                '}';
    }
}

class RollDice {
    public int RollDice () {
        int DICE_SUM = 0;
        final int DICE_COUNT = 4;
        int[] diceRoll = new int[DICE_COUNT];
        for (int j = 0; j < DICE_COUNT; j++) {
            diceRoll[j] = new Dice().getDICE_NUM();
            DICE_SUM += diceRoll[j];

        }

        return DICE_SUM;
    }
}

class Game {
    final int GAME_SETTER1 = 4;
    final int GAME_SETTER2 = 3;
    int DICE_SUM = new RollDice().RollDice();
    public void Game () {
        if (DICE_SUM % GAME_SETTER1 == 0 || DICE_SUM % GAME_SETTER2 == 0) {
        System.out.println("모든 주사위의 합은 " + DICE_SUM + " 이며 4혹은 3의 배수로 승리 하셨습니다.");

    }
    else {
        System.out.println("모든 주사위의 합은 " + DICE_SUM + " 이며 4와 3의 배수가 아니므로 패배하셨습니다.");
    }

    }
}


public class DiceTest {
    public static void main(String[] args) {
        Game game = new Game();
        game.Game();

    }
}
