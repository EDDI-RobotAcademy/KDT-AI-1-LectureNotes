package problems.prob24;

import customLibrary.navigation.NavigationMap;

public class Problem24 {
    public static void main(String[] args) {
        // 24 ~ 26 까지 모두 완료
        final NavigationMap map = new NavigationMap();
        map.printMyCoordinate();

        map.findGasStation();
        map.printGasStationCoordinates();

        map.calculateDistanceOfGasStation();
        map.findShortest();
    }
}
