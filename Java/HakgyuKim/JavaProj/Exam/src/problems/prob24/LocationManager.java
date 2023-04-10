package problems.prob24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationManager {
    final private int GAS_STATION_NUM = 3;
    List<GasStation> gasStationList = new ArrayList<>();
    List<Double> distanceList = new ArrayList<>();
    Person person = new Person("홍길동");

    public LocationManager() {
        for (int i = 0; i < GAS_STATION_NUM; i++) {
            gasStationList.add(new GasStation("주유소" + (i + 1)));
        }
    }

    public List<GasStation> getGasStationList() {
        return gasStationList;
    }

    public Person getPerson() {
        return person;
    }

    private double calculateDistance (int personCoordinateX,
                                     int personCoordinateY,
                                     int gasStationCoordinateX,
                                     int gasStationCoordinateY) {

        int distanceX = personCoordinateX - gasStationCoordinateX;
        int distanceY = personCoordinateY - gasStationCoordinateY;

        double distance = Math.sqrt(Math.pow(distanceX, 2) +
                                    Math.pow(distanceY, 2));
        return distance;
    }

    public void getClosestStation () {
        for (int i = 0; i < gasStationList.size(); i++) {
            distanceList.add(calculateDistance(person.getLocationX(),
                    person.getLocationY(),
                    gasStationList.get(i).getLocationX(),
                    gasStationList.get(i).getLocationY()));
        }

        double shortestDistance = Collections.min(distanceList);
        int index = distanceList.indexOf(shortestDistance);
        System.out.println(person.getName() + "과 가장 가까운 거리에 있는 주유소는 " +
                gasStationList.get(index).getName() + " 이며 거리는 약" +
                (int)shortestDistance + "m 이다.");
    }
}
