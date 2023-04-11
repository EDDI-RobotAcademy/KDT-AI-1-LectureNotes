package problems.prob24;

import customLibrary.gasStation.GasStation;
import customLibrary.gasStation.MyLocation;

import java.util.ArrayList;
import java.util.List;

public class Problem24 {
    //24, 25, 26 문제 모두 작성.
    public final static float MAX_X = 100f;
    public final static float MIN_X = -100f;
    public final static float MAX_Y = 100f;
    public final static float MIN_Y = -100f;

    public static void main(String[] args) {

        MyLocation myLocation = new MyLocation();

        List<GasStation> gasStationList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            gasStationList.add(new GasStation());
        }

        GasStation nearestGasStation = myLocation.findNearestGasStation(gasStationList);
        System.out.println(myLocation);
        System.out.println();
        System.out.println("nearest gasStation");
        System.out.println(nearestGasStation);
        System.out.println();
        System.out.println(gasStationList);
    }
}
