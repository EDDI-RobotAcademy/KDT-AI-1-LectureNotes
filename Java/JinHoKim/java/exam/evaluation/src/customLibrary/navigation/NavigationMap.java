package customLibrary.navigation;

import customLibrary.utility.random.CustomRandom;

import java.util.*;
import java.util.stream.Collectors;

public class NavigationMap {
    final private int X_MAX = 10;
    final private int Y_MAX = 10;
    private Coordinate myCoordinate;
    private List<GasStation> gasStationList;
    private Map<String, Float> gasStationDistanceMap;

    public NavigationMap() {
        this.myCoordinate = new Coordinate(
                CustomRandom.generateNumber(X_MAX),
                CustomRandom.generateNumber(Y_MAX)
        );

        gasStationList = new ArrayList<>();
        gasStationDistanceMap = new HashMap<>();
    }

    public void printMyCoordinate () {
        System.out.println("현재 좌표: " + myCoordinate);
    }

    public void findGasStation() {
        final int MIN = 3;
        final int MAX = 5;
        final int randomGasStationCount = CustomRandom.generateNumber(MIN, MAX);

        for (int i = 0; i < randomGasStationCount; i++) {
            char stationName = (char) ('A' + i);
            gasStationList.add(
                new GasStation(
                    String.valueOf(stationName),
                    new Coordinate(
                        CustomRandom.generateNumber(X_MAX),
                        CustomRandom.generateNumber(Y_MAX)
                    )
                )
            );
        }
    }

    public void printGasStationCoordinates() {
        System.out.println("찾은 주유소들의 좌표: \n" + gasStationList);
    }

    public void calculateDistanceOfGasStation() {
        final int currentX = myCoordinate.getX();
        final int currentY = myCoordinate.getY();

        for (int i = 0; i < gasStationList.size(); i++) {
            final GasStation gasStation = gasStationList.get(i);
            final Coordinate gasStationCoordinate = gasStation.getCoordinate();
            final int gasStationX = gasStationCoordinate.getX();
            final int gasStationY = gasStationCoordinate.getY();

            final float distance = (float) Math.sqrt(
                    Math.pow(currentX - gasStationX, 2) +
                    Math.pow(currentY - gasStationY, 2));

            gasStationDistanceMap.put(gasStation.getName(), distance);
        }
    }

    public void findShortest() {
        List<Map.Entry<String, Float>> gasStationMap =
                gasStationDistanceMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());

        for (Map.Entry<String, Float> entry: gasStationMap) {
            System.out.println(
                    "Station Name: " + entry.getKey() + ", " +
                    "Distance: " + entry.getValue());
        }
    }
}
