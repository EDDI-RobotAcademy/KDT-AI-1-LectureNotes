package examSolve.exam1.pro24;

import examSolve.exam1.customLibrary.navigation.NavigationMap;
// 문제 24번부터 26번
public class Pro24 {
    public static void main(String[] args) {
        // 네비게이션 맵 객체를 생성
        final NavigationMap map = new NavigationMap();
        // 나의 좌표를 출력
        map.printMyCoordinate();

        // 주유소를 생성하고 좌표를 출력
        map.findGasStation();
        map.printGasStationCoordinate();

        // 주유소와 나의 거리 계산
        map.calculateDistanceOfGasStation();
        // 계산 후 가까운 순으로 정렬하여 출력
        map.findShortestGasStation();
    }
}
