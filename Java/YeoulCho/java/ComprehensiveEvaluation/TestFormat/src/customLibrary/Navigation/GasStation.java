package customLibrary.Navigation;

public class GasStation {
    private String name;
    private Coordinate coordinate;

    public GasStation(String name, Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "name='" + name + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
