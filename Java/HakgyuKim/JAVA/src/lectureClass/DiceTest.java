package lectureClass;
class Dice {
    final int DICE_MAX = 6;
    final int DICE_MIN = 1;
    final int DICE_NUM = (int)(Math.random() * (DICE_MAX - DICE_MIN + 1)) + DICE_MIN;

    public Dice() {
    }

    public int getDICE_NUM() {
        return DICE_NUM;
    }
}


public class DiceTest {
    public static void main(String[] args) {
        final int GAME_SETTER1 = 4;
        final int GAME_SETTER2 = 3;
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();

        final int DICE_SUM = dice1.getDICE_NUM() + dice2.getDICE_NUM() +
                dice3.getDICE_NUM() + dice4.getDICE_NUM();
        System.out.println("첫 번째 주사위 값: " + dice1.getDICE_NUM());
        System.out.println("두 번째 주사위 값: " + dice2.getDICE_NUM());
        System.out.println("세 번째 주사위 값: " + dice3.getDICE_NUM());
        System.out.println("네 번째 주사위 값: " + dice4.getDICE_NUM());

        if (DICE_SUM % GAME_SETTER1 == 0 || DICE_SUM % GAME_SETTER2 == 0) {
            System.out.println("모든 주사위의 합은 " + DICE_SUM + " 이며 4와 3의 배수로 승리 하셨습니다.");

        }
        else if (DICE_SUM % GAME_SETTER1 == 0) {
            System.out.println("모든 주사위의 합은 " + DICE_SUM + " 이며 4의 배수로 승리 하셨습니다.");

        }
        else if (DICE_SUM % GAME_SETTER2 == 0) {
            System.out.println("모든 주사위의 합은 " + DICE_SUM + " 이며 3의 배수로 승리 하셨습니다.");

        }
        else {
            System.out.println("모든 주사위의 합은 " + DICE_SUM + " 이며 3과 4의 배수가 아니므로 패배하셨습니다.");
        }
    }
}
