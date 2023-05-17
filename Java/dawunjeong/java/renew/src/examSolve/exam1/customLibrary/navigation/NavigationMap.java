package examSolve.exam1.customLibrary.navigation;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NavigationMap {
    final private int X_MAX = 10;
    final private int Y_MAX = 10;

    final private Coordinate mycoordinate;
    final private List<GasStation> gasStationList;
    final private Map<String, Float> gasStationDistanceMap;

    // 네비게이션 맵 객체를 생성할 때 나의 좌표를 생성하고
    // 주유소 리스트와 주유소와의 거리를 Map으로 생성할 것이다.
    public NavigationMap() {
        this.mycoordinate = new Coordinate(
                CustomRandomNumber.generateRandomNumber(0,X_MAX),
                CustomRandomNumber.generateRandomNumber(0,Y_MAX));
        gasStationList = new ArrayList<>();
        gasStationDistanceMap = new HashMap<>();
    }

    // 생성한 나의 좌표를 출력
    public void printMyCoordinate(){
        System.out.println("현재 나의 좌표는 " + mycoordinate + "입니다.");
    }

    // 3개에서 5개 사이의 랜덤한 주유소를 생성하고
    // 주유소 개수만큼 루프를 돌며 A부터 순차적으로 이름을 부여한다.
    // 부여한 이름과 랜덤으로 생성한 주유소 좌표는
    // GasStation 객체를 생성하며 입력해줄 것이다.
    // 이후 그 객체는 주유소 리스트에 넣을 것이다.
    public void findGasStation(){
        final int MIN = 3;
        final int MAX = 5;
        final int randomGasStationNum = CustomRandomNumber.generateRandomNumber(MIN,MAX);

        for(int i = 0; i < randomGasStationNum; i++){
            char gasStationName = (char) ('A' + i);
            gasStationList.add(
                    new GasStation(String.valueOf(gasStationName),
                    new Coordinate(CustomRandomNumber.generateRandomNumber(0, X_MAX),
                                   CustomRandomNumber.generateRandomNumber(0,Y_MAX))));
        }
    }

    // 만든 주유소 리스트를 출력한다.
    // 아래 출력문은 GasStation의 toString return 형식과 같이
    // 주유소 이름과 좌표가 출력된다.
    public void printGasStationCoordinate(){
        System.out.println("주유소의 좌표는 " + gasStationList + "입니다.");
    }

    // 주유소와의 거리를 계산한다.
    // 루트는 Math.sqrt()을 사용하고
    // 제곱은 Math.pow(x, 2) 형태를 사용한다.

    // 우선 기준이 되는 나의 좌표를 생성한 mycoordinate 객체에서 가져온다.
    // 주유소의 개수만큼 루프를 돌며 해당 주유소와 나와의 거리를 계산한다.
    // distance라는 변수를 생성하여 계산한 거리를 대입한다.
    // 대각선의 길이는 루트(가로의 제곱 + 세로의 제곱)이다.

    public void calculateDistanceOfGasStation(){
        final int currentMyX = mycoordinate.getX();
        final int currentMyY = mycoordinate.getY();

        for(int i = 0; i < gasStationList.size(); i++){
            final GasStation gasStation = gasStationList.get(i);
            final Coordinate gasStationCoordinate = gasStation.getCoordinate();
            final int gasStationX = gasStationCoordinate.getX();
            final int gasStationY = gasStationCoordinate.getY();

            // Math.sqrt(가로의 제곱 + 세로의 제곱)
            // 가로의 제곱 = Math.pow(나의 가로 좌표 - 주유소의 가로 좌표, 2)
            // 세로의 제곱 = Math.pow(나의 세로 좌표 - 주유소의 세로 좌표, 2)
            final float distance = (float) Math.sqrt(
                    Math.pow(currentMyX - gasStationX,2) + Math.pow(currentMyY - gasStationY,2));

            // 이후 위에서 계산한 distance는 gasStationDistanceMap에 대입한다.
            // 주유소의 이름을 key로
            // 주유소와 나와의 거리를 value로 대입한다.
            gasStationDistanceMap.put(gasStation.getGasStationName(),distance);
        }
    }

    // 가장 가까운 주유소를 찾는 메소드
    // 가까운 주유소 순서대로 리스트를 만들어 출력할 것이다.
    public void findShortestGasStation(){
        // Map.Entry<String, Float> 타입의 gasStationMap 리스트를 생성
        // Map.Entry에는 value를 비교하는 comparingByValue 메소드를 갖고 있다.
        // 이 메소드를 활용하여 value를 순차적으로 정렬할 것이다.

        // gasStationDistanceMap의 전체 key와 value값을 가져와서
        // 스트림으로 변환한 후
        // value를 비교해서 sort() -> 오름차순으로 정렬할 것이다.
        // 이후 collect() 메소드를 사용하여 List로 변환할 것이다.
        // 참고! 여기서 만약 내림차순으로 정렬하고 싶다면
        // sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))로 표현하면 된다.

        // collect() 메소드는 Stream 인터페이스에 속한 메소드 중 하나
        List<Map.Entry<String, Float>> gasStationMap =
                gasStationDistanceMap.entrySet().stream().      // 전체 key와 value값을 가져오고
                        sorted(Map.Entry.comparingByValue()).   // value값을 비교해서 오름차순으로 정렬하고
                        collect(Collectors.toList());           // Stream을 List로 변환할 것이다.

        // gasStationMap 리스트를 돌면서 각 요소를 Map.Entry<String, Float> 타입의 entry 변수에 할당하고
        // 그 entry 변수를 출력할거야
        // 주유소 이름(Station Name)은 entry 맵의 key이고
        // 주유소와의 거리(Distance)는 entry 맵의 value가 되는 것이다.
        for (Map.Entry<String, Float> entry: gasStationMap) {
            System.out.println("Station Name: " + entry.getKey() + ", " +
                            "Distance: " + entry.getValue());
        }
    }

}
