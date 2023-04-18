package examSolve.exam1.customLibrary.navigation;

// 문제 24번
// 지도 상 현재 자신의 위치를 표기할 수 있는 좌표 (x, y)값을 랜덤으로 배치해 봅시다.
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
