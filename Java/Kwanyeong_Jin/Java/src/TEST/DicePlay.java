package TEST;

import utility.random.CustomRandom;

class Game {
    private Dice1 dice1;
    private Dice2 dice2;
    private Dice3 dice3;
    public Fun_Dice1 fun_Dice1;
    public Fun_Dice2 fun_Dice2;
    public Fun_Dice3 fun_Dice3;
// 여러 클래스를 하나의 배열에 넣어서 어떻게 필드와 생산자를 간결하게 할 수 있을까요?
    public Game() {
        this.dice1 = new Dice1();
        this.dice2 = new Dice2();
        this.dice3 = new Dice3();
        final int dice1num = dice1.GetDice1Num();
        final int dice2num = dice2.GetDice2Num();
        final int dice3num = dice3.GetDice3Num();
        this.fun_Dice1 = new Fun_Dice1(dice1num);
        this.fun_Dice2 = new Fun_Dice2(dice2num);
        this.fun_Dice3 = new Fun_Dice3(dice3num);
    }

    public void playGame(){
        if (fun_Dice1.checkNum() == true) {
            fun_Dice2.checkNum();
            fun_Dice3.checkNum();
            }
    }


}

class Dice1{
    final public int diceNum;
    final private int MAX = 6;
    final private int MIN =1;

    public Dice1(){
        this.diceNum = CustomRandom.generateNumber(MIN, MAX);
    }

    public int GetDice1Num(){
        return diceNum;
    }

    public String Infodice(){
        return "1번째 주사위는 " + diceNum + "입니다.";
    }
}

class Dice2{
        private int diceNum;
        final private int MAX = 6;
        final private int MIN =1;

        public Dice2(){
            this.diceNum = CustomRandom.generateNumber(MIN, MAX);
        }

    public int GetDice2Num() {
        return diceNum;
    }
    public String Infodice(){
        return "2번째 주사위는 " + diceNum + "입니다.";
        }

}

class Dice3{
    private int diceNum;
    final private int MAX = 6;
    final private int MIN =1;

    public Dice3(){
        this.diceNum = CustomRandom.generateNumber(MIN, MAX);
    }

    public int GetDice3Num() {
        return diceNum;
    }
    public String Infodice(){
        return "3번째 주사위는 " + diceNum + "입니다.";
    }

}

class Fun_Dice1 {
    private Dice1 dice1;
    final private int Even = 2;
    final public int getdice1Num;

    public Fun_Dice1(int getdice1Num ){
        Dice1 dice1 = new Dice1();
        this.getdice1Num = getdice1Num;
    }

    public Boolean checkNum() {
        if (getdice1Num % Even == 0) {
            System.out.println( "1번째 주사위는 " + getdice1Num + "입니다. 2번째 3번째 주사위를 돌리겠습니다.");
           return true;
        } else {
            System.out.println("1번째 주사위는 " + getdice1Num + "입니다. 2번째 3번째 주사위를 둘릴 수 없으니 " +
                    "다시 첫번째 주사위를 돌리길 바랍니다.");
            return false;
        }
        }
    }

class Fun_Dice2 {
    private Dice2 dice2;
    final public int getdice2Num;

    public Fun_Dice2(int getdice2Num){
        this.getdice2Num = getdice2Num;
    }

    public void checkNum(){
        System.out.println( "2번째 주사위는 " + getdice2Num + "입니다. ");
    }
}

class Fun_Dice3{
    private Dice3 dice3;
    final public int minuTreepoint = 1;
    final public int plusuTwopoint = 3;
    final public int defeat = 4;
    final public int getdice3Num;

    public Fun_Dice3(int getdice3Num ){
        this.getdice3Num = getdice3Num;
    }
    public void checkNum(){
        if (getdice3Num == minuTreepoint){
            System.out.printf("3번째 주사위가 %d이므로 상대방의 3점을 뺐었습니다.", getdice3Num);
        }
        else if
            (getdice3Num == plusuTwopoint){
            System.out.printf("3번째 주사위가 %d이므로 자신의 점수를 2점 추가하였습니다.", getdice3Num);
            }
        else if (getdice3Num == defeat){
            System.out.printf("3번째 주사위가 %d이므로 당신은 패배하였습니다.", getdice3Num);
        }
        else {
            System.out.printf("3번째 주사위가 %d이므로 아무일도 일어나지 않았습니다.", getdice3Num);
        }
    }
}

public class DicePlay {
    public static void main(String[] args) {
        Game test  = new Game();
        test.playGame();
        }
}





