package problems.prob24;

import java.util.*;

public class GasManager {

    MyPosition myPosition = new MyPosition();

    List<GasStation> gasStationList = new ArrayList<>();
    final int GAS_STATION_NUM = 3;
    public void addGasStation(){
        for(int i=0; i<GAS_STATION_NUM; i++){
            gasStationList.add(new GasStation("주유소"+(i+1)));
        }
    }
    public void calculateDistance(){
        int myX = myPosition.getX();
        int myY = myPosition.getY();

        for(int i=0; i<GAS_STATION_NUM; i++){
            GasStation currentGasStation = gasStationList.get(i);
            double distance = Math.sqrt(Math.pow((currentGasStation.getX() - myX),2) + Math.pow((currentGasStation.getY() - myY),2));
            currentGasStation.setDistance(distance);
        }

        gasStationList.sort(Comparator.comparing(GasStation::getDistance));
    }

    public void findClosestGasStation(){
        System.out.println(gasStationList.get(0));
    }

    @Override
    public String toString() {
        return "myPosition=" + myPosition +
                ", gasStationList=" + gasStationList;
    }
}
