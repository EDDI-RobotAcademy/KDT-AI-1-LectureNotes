package problems.prob24;

import customLibrary.math.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Problem24 {
    //24, 25, 26 문제 모두 작성.
    final static float MAX_X = 100f;
    final static float MIN_X = -100f;
    final static float MAX_Y = 100f;
    final static float MIN_Y = -100f;

    public static void main(String[] args) {

        MyLocation myLocation = new MyLocation();

        List<GasStation> gasStationList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            gasStationList.add(new GasStation());
        }

        GasStation nearestGasStation = myLocation.findNearestGasStation(gasStationList);

    }
}
