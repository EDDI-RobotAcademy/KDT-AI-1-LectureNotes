package problems.prob24;

import customLibrary.CustomRandom;

public class FindLocation {
    private int x, y;
    private int[] coordinate = new int[2];

    public FindLocation() {

    }

    public int[] getCoordinate() {
        x = CustomRandom.generateNumber(100);
        y = CustomRandom.generateNumber(100);
        coordinate[0] = x;
        coordinate[1] = y;
        return coordinate;
    }
}
