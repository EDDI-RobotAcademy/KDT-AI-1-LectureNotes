package problems.prob24;

import problems.CustomRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NavigationMap {
    final private int X_MAX = 10;
    final private int Y_MAX = 10;
    private Coordinate myCoordinate;
    private List<GasStation> gasStationList = new ArrayList<>();
    private Map<String, Float> gasStationDistanceMap = new HashMap<>();

    public NavigationMap() {
        this.myCoordinate = new Coordinate(CustomRandom.generateNumber(X_MAX),
                                           CustomRandom.generateNumber(Y_MAX));

        // 좌표를 MAX 값을 설정하여 랜덤으로 설정
    }

    public void printMyCoordinate() {
        System.out.println("현재 좌표: " + myCoordinate);

        // 나의 현재위치 설정
        // 랜덤으로 설정된 myCoordinate 값을 나의 현재위치에 부여
    }

    public void findGasStation() {
        final int MIN = 3;
        final int MAX = 5;
        final int randomGasStationCount = CustomRandom.generateNumber(MIN, MAX);

        for (int i = 0; i < randomGasStationCount; i++) {
            char stationName = (char) ('A' + i);
            gasStationList.add(new GasStation(String.valueOf(stationName), // 이름 설정
                    // char 타입의 stationName 을 String 으로 변환하여 GasStation 생성자에 전달
                    new Coordinate(CustomRandom.generateNumber(X_MAX), CustomRandom.generateNumber(Y_MAX))));
                    // 좌표 축 설정

            // 찾을 주유소들의 이름과 위치를 설정
        }
    }

    public void printGasStationCoordinates() {
        System.out.println("찾은 주유소들의 좌표: \n" + gasStationList);

        // 찾은 주유소들의 주소의 이름과 위치를 출력
    }

    public void calculateDistanceOfGasStation() {
        final int currentX = myCoordinate.getX(); // 나의 x 축 좌표
        final int currentY = myCoordinate.getY(); // 나의 y 축 좌표

        for (int i = 0; i < gasStationList.size(); i++) {
            final GasStation gasStation = gasStationList.get(i);
            final Coordinate gasStationCoordinate = gasStation.getCoordinate();
            final int gasStationX = gasStationCoordinate.getX(); // 주유소의 x 축 좌표
            final int gasStationY = gasStationCoordinate.getY(); // 주유소의 y 축 좌표

            final float distance =
                    (float) Math.sqrt(Math.pow(currentX - gasStationX, 2) + Math.pow(currentY - gasStationY, 2));
                    // Math.sqrt() 제곱근을 계산하는 메서드
                    // Math.pow() 제곱을 계산하는 메서드

            gasStationDistanceMap.put(gasStation.getName(), distance);

            // 나와 주유소가 있는 위치의 거리계산
        }
    }

    public void findShortest() {
        List<Map.Entry<String, Float>> gasStationMap =
                gasStationDistanceMap.entrySet().stream()
                        // Map 의 entrySet() 메소드를 사용하여 key-value 쌍으로 이루어진
                        // Map.Entry 객체들의 Set 을 반환합니다.
                        // 반환된 Set 객체는 stream() 메소드를 사용하여 스트림으로 변환됩니다.
                        .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
                        // Map.Entry 객체를 value 값 기준으로 오름차순으로 정렬합니다.
                        // collect 는 스트림의 모든 요소를 list 에 수집합니다.

        for (Map.Entry<String, Float> entry: gasStationMap) {
            System.out.println("Station Name: " + entry.getKey() + ", " + "Distance: " +entry.getValue());
        }
    }
}
