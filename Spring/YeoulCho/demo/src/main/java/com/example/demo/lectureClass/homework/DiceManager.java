package com.example.demo.lectureClass.homework;

import com.example.demo.lectureClass.utility.random.CustomRandom;

public class DiceManager {
    final int MIN =1;
    final int MAX =6;
    public int randomDiceNumber;
    private int Dice;
    public int tmpSum;
    public void rollDice(){
        randomDiceNumber = CustomRandom.generateNumber(MIN,MAX);
    }

    public DiceManager() {
         rollDice();
    }
    public int sumTwoDicel(){
        DiceManager d1 = new DiceManager();
        DiceManager d2 = new DiceManager();
        int tmpSum = d1.randomDiceNumber +d2.randomDiceNumber;
        return tmpSum;
    }
    public void checkWinner(){
        if(tmpSum %2 ==0){
            System.out.println("주사위의 합: " + tmpSum + "짝수이므로 승리하였습니다");
        } else{
            System.out.println("주사위의 합: " + tmpSum + "홀수이므로 패배하였습니다");}

    }

    public int getTmpSum() {
        return tmpSum;
    }
}
