package evaluation.prob24;

public class GasStation {
    private String name;// 주유소 이름?
    private Coordinate coordinate;// 무엇을 조직하는 것인가?

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
                '}' + '\n';
    }
}