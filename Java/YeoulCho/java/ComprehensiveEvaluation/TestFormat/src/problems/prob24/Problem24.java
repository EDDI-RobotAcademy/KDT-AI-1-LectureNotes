package problems.prob24;

import customLibrary.utility.random.CustomRandom;

import java.util.Scanner;

class Map {
    String Name;
    int x;
    int y;


    public Map(String name) {
        this.Name = name;
        this.x = CustomRandom.generateNumber(10);
        this.y = CustomRandom.generateNumber(10);
    }

    public Map() {
        this.x = x;
        this.y = y;
    }

    public double findShortDistance(int x, int y){
        double shortDistance = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        return shortDistance;
    }


    @Override
    public String toString() {
        return Name + " 위치(" +
                +x + ","
                + y +
                ')';
    }
}

public class Problem24 {
    public static void main(String[] args) { //24~25번 완료했습니다.
        Map mylocation = new Map("mylocation");
        System.out.println(mylocation);
        Map gasStaion = new Map("gasStaion");
        System.out.println(gasStaion);
        Scanner scan = new Scanner(System.in);



    }
}
