package examSolve.exam1.customLibrary.navigation;

public class GasStation {

    private String gasStationName;
    Coordinate coordinate;

    public GasStation(String gasStationName, Coordinate coordinate) {
        this.gasStationName = gasStationName;
        this.coordinate = coordinate;
    }

    public String getGasStationName() {
        return gasStationName;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "gasStationName='" + gasStationName + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
