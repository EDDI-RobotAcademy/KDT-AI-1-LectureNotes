package problems.prob24;

import customLibrary.CustomRandom;

// 24번, 25번, 26번 해결 완료
public class Problem24 {
    public static void main (String[] args) {

        final int START = 0;
        final int END = 100;

        final int MY_COORDINATE_X = CustomRandom.generateNumber(START, END);
        final int MY_COORDINATE_Y = CustomRandom.generateNumber(START, END);

        final int GAS_STATION_COORDINATE_X = CustomRandom.generateNumber(START, END);
        final int GAS_STATION_COORDINATE_Y = CustomRandom.generateNumber(START, END);

        System.out.println("나의 좌표 : " + MY_COORDINATE_X + ", " + MY_COORDINATE_Y);
        System.out.println("주유소의 좌표 : " + GAS_STATION_COORDINATE_X + ", " + GAS_STATION_COORDINATE_Y);

        int X_DISTANCE = MY_COORDINATE_X - GAS_STATION_COORDINATE_X;
        int Y_DISTANCE = MY_COORDINATE_Y - GAS_STATION_COORDINATE_Y;

        double X_SQUARE = Math.pow(X_DISTANCE, 2);
        double Y_SQUARE = Math.pow(Y_DISTANCE, 2);

        double result = Math.sqrt(X_SQUARE + Y_SQUARE);

        System.out.println("나와 주유소 사이의 최단 거리 : " + result);
    }
}
