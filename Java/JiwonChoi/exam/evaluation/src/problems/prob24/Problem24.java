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

class Coordinate {
    int X;
    int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Coordinate() {
        X = Random.randomNumber(-100, 100);
        Y = Random.randomNumber(-100, 100);
    }

    public void distance(Coordinate myCoordinate, Coordinate gasCoordinate){
        int myCoordinatet_X = myCoordinate.getX();
        int myCoordinatet_XAbs = Math.abs(myCoordinatet_X);
        int gasCoordinatet_X = gasCoordinate.getX();
        int gasCoordinatet_XAbs = Math.abs(gasCoordinatet_X);


    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}


public class Problem24 {
    public static void main(String[] args) {

        Coordinate myCoordinate = new Coordinate();
        Coordinate gasStation1Coordinate = new Coordinate();
        Coordinate gasStation2Coordinate = new Coordinate();
        Coordinate gasStation3Coordinate = new Coordinate();
        System.out.println(myCoordinate);


    }
}
