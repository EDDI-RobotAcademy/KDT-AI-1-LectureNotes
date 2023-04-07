package customLibrary.gasStation;

import customLibrary.math.RandomGenerator;
import problems.prob24.Problem24;

import java.util.List;

public class MyLocation {
    private float x;
    private float y;

    public MyLocation() {
        RandomGenerator randomGenerator = new RandomGenerator();
        x = randomGenerator.randomFloat(Problem24.MIN_X, Problem24.MAX_X);
        y = randomGenerator.randomFloat(Problem24.MIN_Y, Problem24.MAX_Y);
    }

    public GasStation findNearestGasStation(List<GasStation> gasStationList) {
        float nearestDistance = Problem24.MAX_X - Problem24.MIN_X;
        GasStation nearestGasStation = null;
        for (GasStation gasStation : gasStationList) {
            float targetX = gasStation.getLocationX();
            float targetY = gasStation.getLocationY();
            float DistanceMyLocation2GasStation = caculateDistance(targetX, targetY);
            if (nearestDistance > DistanceMyLocation2GasStation) {
                nearestGasStation = gasStation;
                nearestDistance = DistanceMyLocation2GasStation;
            }
        }
        return nearestGasStation;
    }


    private float caculateDistance(float targetX, float targetY) {
        return (float) Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
    }

    @Override
    public String toString() {
        return "MyLocation{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
