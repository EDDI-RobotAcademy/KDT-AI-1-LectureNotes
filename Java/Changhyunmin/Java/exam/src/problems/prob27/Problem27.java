package problems.prob27;

import customLibrary.CustomRandom;

class Dice{
    int MIN = 1;
    int MAX = 12;
    int DiceNum;
    public Dice(){
        DiceNum = CustomRandom.generateNumber(MIN,MAX);
    }

    @Override
    public String toString() {
        return "주사위값:" + DiceNum;
    }
}


public class Problem27 {
    public static void main(String[] args) {//28, 29, 30PASS
        Dice dice = new Dice();
        System.out.println(dice);

    }
}
