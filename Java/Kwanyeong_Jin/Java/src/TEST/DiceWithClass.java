package TEST;

class Dice_GAME extends Score {
    public int SUM;
    final public Score score = new Score();

    public Dice_GAME(){
        this.SUM = score.getSum();
    }

    public String getResult() {
        String eachDice = String.format("1번째 주사위의 값은 %d이고 2번째 주사위의 값은 %d이고\n3번째 주사위의 값은 %d이고 4번째 주사위의 값은 %d입니다.\n", Dice1.getResNum(), Dice2.getResNum(), Dice3.getResNum(), Dice4.getResNum(), SUM);
        if (SUM % 4 == 0 || SUM % 3 == 0) {
          String totalResult = String.format("네 주사위에 합이 %d이므로 3 또는 4배의 배수에 해당되어 승리하였습니다.", SUM);
            return eachDice + totalResult;
        } else {
          String totalResult = String.format("네 주사위에 합이 %d이므로 3 또는 4배의 배수에 해당되지 않아 패배하였습니다.", SUM);
            return eachDice + totalResult;
        }
    }
}

class Dice {
    final int MAX = 6;
    final int MIN = 1;
    public Dice() {
    }
    public int getResNum() {
        int DiceRes = (int)(Math.random() * MAX) + MIN;
        return DiceRes;
    }
}

class Score {
    final public int score1;
    final public int score2;
    final public int score3;
    final public int score4;
    final public Dice Dice1 = new Dice();
    final public Dice Dice2 = new Dice();
    final public Dice Dice3 = new Dice();
    final public Dice Dice4 = new Dice();

    public Score(){
       this.score1 = Dice1.getResNum();
       this.score2 = Dice2.getResNum();
       this.score3 = Dice3.getResNum();
       this.score4 = Dice4.getResNum();
    }

    public int getSum(){
        int sum = (score1 + score2 + score3 + score4);
        return sum;
    }
}
public class DiceWithClass {
    public static void main(String[] args) {
        final Dice_GAME test = new Dice_GAME();
        System.out.println(test.getResult());
    }
}
