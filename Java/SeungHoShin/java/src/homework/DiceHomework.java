package homework;

import java.util.Scanner;

class Dice{
    final private int diceNumber;
    final private int MAX =6;
    final private int MIN =1;


    public Dice(){
        this.diceNumber = (int)(Math.random()*MAX)+MIN;


    }
    public int getDiceNumber(){
        return diceNumber;

    }



}

class Score{
    final private int Score1;
    final private int Score2;
    final private int Score3;
    final private int Score4;

    public Score(int Score1,int Score2,int Score3,int Score4)
    {
        this.Score1=Score1;
    this.Score2=Score2;
    this.Score3=Score3;
    this.Score4=Score4;}

    public int getSumScore(){
        return this.Score1 +this.Score2 +this.Score3 +this.Score4;
    }

}



class Game{
    //필드

    }




