package TEST;

//class Dice_GAME {
//    final int SUM;
//    final int RES;
//
//    public GAME(){
//        this.SUM = Score.getSum();
//        this.RES = RES;
//    }
//
//    public String getResult(){
//        System.out.printf("1번째 주사위의 값은 %d이고\n" +
//                "2번째 주사위의 값은 %d이고\n" +
//                "3번째 주사위의 값은 %d이고\n" +
//                "4번째 주사위의 값은 %d입니다.\n ", );
//        if ( SUM % 4 == 0 || SUM % 3 == 0 ){
//            System.out.printf("네 주사위에 합이 %d이므로 3 또는 4배의 배수에 해당되어 승리하였습니다.");
//        }
//        else {
//            System.out.printf("네 주사위에 합이 %d이므로 3 또는 4배의 배수에 해당되지 않아 패배하였습니다.");
//        }
//
//    }
//}

class Dice {
    public int DICE_RES;
//    final int MAX = 6;
//    final int MIN = 1;

    public Dice() {
        this.DICE_RES = 1;
    }
    public int getResNum() {
//        int DiceRes = (int)(Math.random() * MAX) + MIN;
        return 1;
    }
}


//class Score {
//    final public int score1;
//    final public int score2;
//    final public int score3;
//    final public int score4;
//    public Dice Dice1 = new Dice();
//    public Dice Dice2 = new Dice();
//    public Dice Dice3 = new Dice();
//    public Dice Dice4 = new Dice();
//
//    public Score(){
//       this.score1 = Dice1.getResNum();
//       this.score2 = Dice2.getResNum();
//       this.score3 = Dice3.getResNum();
//       this.score4 = Dice4.getResNum();
//    }
//
//    public int getSum(){
//        int sum = (score1 + score2 + score3 + score4);
//        return sum;
//    }
//}

public class DiceWithClass {
    public static void main(String[] args) {
//    Dice_GAME DiceGame = new DiceGame();
//        System.out.printf(DiceGame());
        Dice test = new Dice();
        System.out.println(test.getResNum());
    }
}
