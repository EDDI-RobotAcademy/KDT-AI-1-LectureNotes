package problems.prob24;

import customLibrary.CalculateDistance;

import java.util.ArrayList;
import java.util.List;

public class GetDistance {
    private int [] myLocation;
    private List<int[]> gasLocationList = new ArrayList<>();
    private final int gasStaionNumber = 5;
    private List<Float> distanceList = new ArrayList<>();

    public GetDistance() {
        FindLocation findLocation = new FindLocation();
        myLocation = findLocation.getCoordinate();
        for (int i = 0; i < gasStaionNumber; i++) {
            gasLocationList.add(findLocation.getCoordinate());
        }
    }

    public void getDistanceList() {
        for (int i = 0; i < gasStaionNumber; i++) {
            distanceList.add(CalculateDistance.getDistance(myLocation, gasLocationList.get(i)));
        }
        System.out.println(gasLocationList.get(0)[1]);
        for (float i:distanceList) {
            System.out.println(i);
        }
    }
}
