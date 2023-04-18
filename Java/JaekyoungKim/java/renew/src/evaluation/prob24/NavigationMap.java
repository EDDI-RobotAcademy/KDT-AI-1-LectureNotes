package evaluation.prob24;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NavigationMap {
    final private int X_MAX = 10;// x 좌표의 최대값
    final private int Y_MAX = 10;//y 좌표의 최댓값
    private Coordinate myCoordinate;
    private List<GasStation> gasStationList;
    private Map<String, Float> gasStationDistanceMap;// 주유소와의 거리 관렵 맵?

    public NavigationMap() {
        this.myCoordinate = new Coordinate(
                CustomRandom.generateNumber(X_MAX),
                CustomRandom.generateNumber(Y_MAX)
        );// xy가 최대 10인 랜덤 위치를 정해주는 메서드

        gasStationList = new ArrayList<>();
        gasStationDistanceMap = new HashMap<>();
    }

    public void printMyCoordinate () {
        System.out.println("현재 좌표: " + myCoordinate);// Coordinate의 to string으로  xy 좌표 값을 알려준다.
    }

    public void findGasStation() {
        final int MIN = 3;
        final int MAX = 5;
        final int randomGasStationCount = CustomRandom.generateNumber(MIN, MAX);// 3개에서 5개 사이의 주유소 생성

        for (int i = 0; i < randomGasStationCount; i++) {// 주유소의 갯수만큼 주유소의 이름 생성하고
            char stationName = (char) ('A' + i);//ABCD 순으로 생성
            gasStationList.add(//
                    new GasStation(// 이름과 xy좌표값을 갖는 주유소들을 생성한다.
                            String.valueOf(stationName),
                            new Coordinate(
                                    CustomRandom.generateNumber(X_MAX),
                                    CustomRandom.generateNumber(Y_MAX)
                            )// 생성된 주유소의 좌표값 지정해줌
                    )
            );
        }
    }

    public void printGasStationCoordinates() {
        System.out.println("찾은 주유소들의 좌표: \n" + gasStationList);// 생성된 주유소들의 이름과 좌표값들 나열해줌
    }

    public void calculateDistanceOfGasStation() {
        final int currentX = myCoordinate.getX();
        final int currentY = myCoordinate.getY();

        for (int i = 0; i < gasStationList.size(); i++) {
            final GasStation gasStation = gasStationList.get(i);//리스트의 0~gasStation.size()까지의 주유소 가져온다.
            final Coordinate gasStationCoordinate = gasStation.getCoordinate();//주유소의 이름과 좌표 가져욤
            final int gasStationX = gasStationCoordinate.getX();// x좌표
            final int gasStationY = gasStationCoordinate.getY();// y좌표

            final float distance = (float) Math.sqrt(//더한것 루트
                    Math.pow(currentX - gasStationX, 2) +//x좌표의 제곱
                            Math.pow(currentY - gasStationY, 2));//y좌표의 제곱

            gasStationDistanceMap.put(gasStation.getName(), distance);// 직선 거리 나옴
        }
    }

    public void findShortest() {
        List<Map.Entry<String, Float>> gasStationMap =
                gasStationDistanceMap.entrySet().stream().sorted(Map.Entry.comparingByValue())// 거리 순으로 정렬하는 듯.
                        .collect(Collectors.toList());

        for (Map.Entry<String, Float> entry: gasStationMap) {
            System.out.println(
                    "Station Name: " + entry.getKey() + ", " +
                            "Distance: " + entry.getValue());
        }
    }
}