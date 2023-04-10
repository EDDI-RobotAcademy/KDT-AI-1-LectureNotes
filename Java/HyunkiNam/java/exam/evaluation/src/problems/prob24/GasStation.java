package problems.prob24;

import customLibrary.CustomRandom;

public class GasStation extends Coordinate{

    final String name;
    double distance;

    public GasStation(String name){
        this.name = name;
        this.x = CustomRandom.generateNumber(MAX_X);
        this.y = CustomRandom.generateNumber(MAX_Y);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", distance=" + distance +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
