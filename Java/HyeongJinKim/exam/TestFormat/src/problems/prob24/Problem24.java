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

// Sync를 안하고 주석을 달고 있었는데
// 선생님께서 더 자세한 코드를 올려주셨다.