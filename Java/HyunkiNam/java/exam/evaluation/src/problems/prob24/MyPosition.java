package problems.prob24;

import customLibrary.CustomRandom;

public class MyPosition extends Coordinate {

    public MyPosition(){
        this.x = CustomRandom.generateNumber(MAX_X);
        this.y = CustomRandom.generateNumber(MAX_Y);
    }

    @Override
    public String toString() {
        return "{x=" + x +
                ", y=" + y +
                '}';
    }
}
