package problems.prob24;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {

    int xCoordinate;
    int yCoordinate;


    List<Integer> totalCoordinate = new ArrayList<>();

    int maxCoordinate = 0;
    int minCoordinate = 1000;

    public List<Integer> getTotalCoordinate() {
        return totalCoordinate;
    }

    public Coordinate() {
        this.totalCoordinate.add(this.xCoordinate = (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate));
        this.totalCoordinate.add(this.yCoordinate = (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate));
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void calculateCoordinate(List<Coordinate> coordinateArrayList) {
        int minusX;
        int minusY;
        int sumXY;
        int diagonal;

        minusX = (int) Math.pow((coordinateArrayList.get(0).getxCoordinate() - coordinateArrayList.get(1).getxCoordinate()), 2);
        minusY = (int) Math.pow((coordinateArrayList.get(0).getyCoordinate() - coordinateArrayList.get(1).getyCoordinate()), 2);
        sumXY = minusX + minusY;
        diagonal = (int) Math.sqrt(sumXY);

        System.out.println("가장 빠르게 갈 수 있는 길이는 " + diagonal + " 입니다.");


    }

}
