package homework.sixth.practice;

public class Dice {
    final private int MAX = 6;
    final private int MIN = 1;

    public Dice(){
    }

    public int draw() {
        return  (int)(Math.random() * MAX) + MIN;
    }

}
