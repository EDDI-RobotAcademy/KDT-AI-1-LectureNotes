package problems.prob24;
/*
[ 복합 문제 24 ~ 26 ]
지도 상 현재 자신의 위치를 표기할 수 있는 좌표 (x, y)값을 랜덤으로 배치해 봅시다.
지도 상 주유소의 위치를 마찬가지로 (x, y) 형태의 좌표로 랜덤하게 배치해 봅시다.
현재 자신의 위치를 기준으로 최단 거리에 놓인 주유소를 찾아보세요.
힌트: 대각선의 길이는 루트(가로의 제곱 + 높이(세로)의 제곱) 입니다. 피타고라스 정리 혹은 삼각형의 대각선 길이로 봐도 무방합니다.
루트는 Math.sqrt()로 사용할 수 있으며 제곱의 경우엔 Math.pow(x, 2) 형태로 x를 제곱할 수 있습니다. x * x 로 처리해도 무방하니 편한 형태로 사용하면 되겠습니다.
 */

import customLibrary.Random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;


class MyCoordinate {
    static int X = Random.randomNumber(-100, 100);
    static int Y = Random.randomNumber(-100, 100);
    static ArrayList<GasStationCoordinate> nearGasStationsList = new ArrayList<>();

    public void AddGasStation (String gasStationName) {
        nearGasStationsList.add(new GasStationCoordinate(gasStationName));
    }

    @Override
    public String toString() {
        return "내 위치 : " +
                "(" + X +
                ", " + Y + ")";
    }
}

class GasStationCoordinate {
    String gasStationName ;
    int X;
    int Y;
    double distance;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getDistance() {
        return distance;
    }

    public GasStationCoordinate(String gasStationName) {
        this.gasStationName = gasStationName;
        X = Random.randomNumber(-100, 100);
        Y = Random.randomNumber(-100, 100);
    }


    public void distance(){
        int myCoordinatet_X = MyCoordinate.X;
        int gasCoordinatet_X = getX();
        int distance_XtoX = 0;

        if(myCoordinatet_X > gasCoordinatet_X) {
            distance_XtoX =  Math.abs(myCoordinatet_X - gasCoordinatet_X);
        } else if (myCoordinatet_X <= gasCoordinatet_X) {
            distance_XtoX = Math.abs(gasCoordinatet_X-myCoordinatet_X);
        }

        int myCoordinatet_Y = MyCoordinate.Y;
        int gasCoordinatet_Y = getY();
        int distance_YtoY  = 0;

        if(myCoordinatet_Y > gasCoordinatet_Y) {
            distance_YtoY =  Math.abs(myCoordinatet_Y - gasCoordinatet_Y);
        } else if (myCoordinatet_X <= gasCoordinatet_Y) {
            distance_YtoY  = Math.abs(gasCoordinatet_Y-myCoordinatet_Y);
        }

        int squareOfDistance =  (int) (Math.pow(distance_XtoX, 2) + Math.pow(distance_YtoY, 2));
        double distance = Math.sqrt(squareOfDistance);

        setDistance(distance);
    }

    @Override
    public String toString() {
        return  "주유소 : " + gasStationName +
                "좌표 : (" + X + "," +
                 Y + ")" + '\n'+
                "거리 : " + distance + '\n';
    }
}


public class Problem24 {
    public static void main(String[] args) {

        MyCoordinate myCoordinate = new MyCoordinate();
        System.out.println(myCoordinate);

        myCoordinate.AddGasStation("gasStation1");
        myCoordinate.AddGasStation("gasStation2");
        myCoordinate.AddGasStation("gasStation3");
        myCoordinate.AddGasStation("gasStation4");

        for (int i = 0; i < myCoordinate.nearGasStationsList.size(); i++) {
            myCoordinate.nearGasStationsList.get(i).distance();
        }
        System.out.println(myCoordinate.nearGasStationsList);


        System.out.println("스트림을 이용한 정렬?????");
        //Stream<GasStationCoordinate> gasStationsStream = null;
        for (int i = 0; i < myCoordinate.nearGasStationsList.size(); i++) {
            var gasStationsStream = List.of (
                    myCoordinate.nearGasStationsList.get(0),
                    myCoordinate.nearGasStationsList.get(1),
                    myCoordinate.nearGasStationsList.get(2),
                    myCoordinate.nearGasStationsList.get(3)

            );
            gasStationsStream.stream().sorted(Comparator.comparing(GasStationCoordinate::getDistance))
                    .collect(Collectors.toList());

        }


    }
}
