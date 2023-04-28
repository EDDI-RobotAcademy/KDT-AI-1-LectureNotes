package evaluation.prob24;

public class Prob24 {
public static void main(String[] args) {

    final NavigationMap map = new NavigationMap();
    map.printMyCoordinate();//현재 위치 알려줌

    map.findGasStation();//주유소 생성하고 이름과 좌표 부여
    map.printGasStationCoordinates();// 이름과 좌표값 출력

    map.calculateDistanceOfGasStation();// 주유소까지의 거리 계산
    map.findShortest();// 가장 짧은 주유소 찾음
}
}
