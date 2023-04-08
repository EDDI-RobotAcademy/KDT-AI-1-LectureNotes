package problems.prob24;

import customLibrary.RandomGenerator;

// 문제 24번부터 26번입니다.
class Location{
    int x;
    int y;

    public Location() {
        x = RandomGenerator.generateNumber(1,10);
        y = RandomGenerator.generateNumber(1,10);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class Problem24 {
    public static void main(String[] args) {
        Location mylocation = new Location();
        System.out.println("나의 위치: " + mylocation);

        Location gasStationLocation = new Location();
        System.out.println("주유소의 위치: " + gasStationLocation);
    }
}
