package customLibrary.Navigation;

public class Coordinate { //좌표
    private int X;
    private int y;

    public Coordinate(int x, int y) {
        this.X = x;
        this.y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "X=" + X +
                ", y=" + y +
                '}';
    }
}
