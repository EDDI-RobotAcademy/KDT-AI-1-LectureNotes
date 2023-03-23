package TEST;

import utility.random.CustomRandom;

class Game {

}

class Dice1{
    private int diceNum;
    final private int MAX = 6;
    final private int MIN =1;

    public Dice1(){
        this.diceNum = CustomRandom.generateNumber(MIN, MAX);
    }
    public String GetDice1Num(){

        if (diceNum % 2 == 0 ){
            return "1번째 주사위는 " + diceNum + "입니다. 2번째 3번째 주사위를 돌리겠습니다.";
        }
        else {
            return "1번째 주사위는 " + diceNum + "입니다. 2번째 3번째 주사위를 둘릴 수 없으니 " +
                    "다시 첫번째 주사위를 돌리길 바랍니다.";
        }
    }
    public Boolean checkNum() {
            if (diceNum % 2 == 0 ){
                return true;
            }
            else {
                return false;
        }
    }

}

class Dice2{
        private int diceNum;
        final private int MAX = 6;
        final private int MIN =1;

        public Dice2(){
            this.diceNum = CustomRandom.generateNumber(MIN, MAX);
        }
        public String GetDice2Num(){
            return "2번째 주사위는 " + diceNum + "입니다.";
        }

}

class Dice3{

}

//class Fun_Dice3{
//
//}
//

public class DicePlay {
    public static void main(String[] args) {
        Dice1 test = new Dice1();
        System.out.println(test.GetDice1Num());
    }
}
