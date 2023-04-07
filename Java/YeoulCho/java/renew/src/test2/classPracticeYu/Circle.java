package test2.classPracticeYu;

public class Circle {
    private int r;
    final float pi=3.14f;
    private float area;
    private float round;

    public void calculateCircleRound(){
        round = 2*r*pi;
    }
    public void calculateCircleArea(){
        area = (float) (Math.pow(r,2) * pi);
    }

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "area=" + area +
                ", round=" + round +
                '}';
    }
}
