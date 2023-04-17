package customLibrary.Navigation;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NavigationMap {
    final private int X_MAX = 10;
    final private int Y_MAX = 10;
    private Coordinate mycoordinate;
    private List<GasStation> gasStationList;

    public NavigationMap() {
        
        this.mycoordinate = new Coordinate(
                CustomRandom.generateNumber(X_MAX),
                        CustomRandom.generateNumber(Y_MAX)
        );
        this.gasStationList = new ArrayList<>();
    }

    public void printMyCoordinate(){
        System.out.println("현재 좌표: "+ mycoordinate);
    }

    public void findGasStaion() { // 주유소 리스트에 랜덤하게 주유소 추가하여 생성
        final int MIN = 3; //주유소 최소 3
        final int MAX = 5; // 주유소 최대 5
        final int randomGasStationCount = CustomRandom.generateNumber(MIN,MAX);

        for(int i =0; i<randomGasStationCount; i++){
            String stationName = ("A"+i);
            gasStationList.add(new GasStation(stationName,new Coordinate(
                    CustomRandom.generateNumber(X_MAX),
                    CustomRandom.generateNumber(Y_MAX)
            )));
        }
    }
    public void printGasStationCoordinates(){
        System.out.println("현재 좌표: "+ gasStationList);
    }


    public void calculateDistanceOfGasStation() {
        final int currentX = mycoordinate.getX();
        final int currentY = mycoordinate.getY();
        double shortDistance = 20;
        for (int i = 0; i < gasStationList.size(); i++) {

            GasStation gasStation = gasStationList.get(i);
            Coordinate gasStationCoordinate = gasStation.getCoordinate();

            final int gasStationX = gasStationCoordinate.getX();
            final int gasStationY = gasStationCoordinate.getY();


            double distance = Math.sqrt(Math.pow(currentX - gasStationX, 2) +
                    Math.pow(currentY - gasStationY, 2));
            if (shortDistance > distance){ //최단거리가 주유소 거리보다 커 -> 그럼 그 주요소를 최단거리로 바꿔 그걸 for문 동안 체크
                shortDistance = distance;

            }

            System.out.println(distance);
        }
        System.out.println("최단거리" + shortDistance);
    }


    public void findShorttest() {

    }
}
